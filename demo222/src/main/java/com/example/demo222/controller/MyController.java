package com.example.demo222.controller;

import com.example.demo222.entity.Comment;
import com.example.demo222.entity.Login;
import com.example.demo222.entity.Question;
import com.example.demo222.service.LoginService;
import com.example.demo222.service.impl.CommentServiceImpl;
import com.example.demo222.service.impl.QuestionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
public class MyController {
    String Hostname=null;
    @Autowired
    LoginService loginService;
    @Autowired
    QuestionServiceImpl questionService;
    @Autowired
    CommentServiceImpl commentService;
    ////这里是首先进入登陆页面，然后再进行其他的操作
    @RequestMapping("/")
    public ModelAndView index(){
        ModelAndView mv = new ModelAndView("login");
        return mv;
    }
    @RequestMapping("/registers")
    public ModelAndView zhuce(){
        ModelAndView mv = new ModelAndView("register");
        return mv;
    }

    //登陆功能
    @PostMapping("/login")
    public ModelAndView Login(@RequestParam("username") String username, @RequestParam("userpassword") String userpassword, Model model){
        Hostname = username;
        List<Login> login= loginService.findByUsernameAndUserpassword(username,userpassword);
        System.out.println(username+":"+userpassword);
        ModelAndView success = new ModelAndView();
        if(login.size()>0){
            List<Question> questions = questionService.findAll();
            List<Question> questions1 = new ArrayList<>();
            int i=1;
            for (Question question:questions){
                Question question2 = new Question(i,question.getUsername(),question.getTitle());
                i++;
                questions1.add(question2);
            }
            model.addAttribute("questions",questions1);
            success.setViewName("success");
        } else {
            success.setViewName("404");
             }
        return success;
    }
    //注册功能
    @PostMapping("/register")
    public ModelAndView register(@RequestParam("username") String username,@RequestParam("password")
                        String password,@RequestParam("password2") String password2,Model model){
        Hostname = username;
        ModelAndView success = new ModelAndView();
        //用户或密码为空的条件判断
        if(username.isEmpty()||password.isEmpty()||password2.isEmpty()){
            success.setViewName("register");
            success.addObject("tip1","用户或密码不能为空");
            return success;
        }
        //两次密码不一样的判断条件
        if(!password.equals(password2)){
            success.setViewName("register");
            success.addObject("tip2","两次密码不一样");
            return success;
        }
        //判断是否取到用户，如果没有就保存在数据库中
        List<Login> us=loginService.findByUsername(username);
        if(us.size()==0){
            Login registers=new Login();
            registers.setUserpassword(password);
            registers.setUsername(username);
            List<Question> questions3 = questionService.findAll();
            List<Question> questions4 = new ArrayList<>();
            int i=1;
            for (Question question:questions3){
                Question question2 = new Question(i,question.getUsername(),question.getTitle());
                i++;
                questions4.add(question2);
            }
            model.addAttribute("questions",questions4);
            loginService.save(registers);
            success.setViewName("success");
        }
        else {
            success.setViewName("404");
        }
        return success;
    }
    @GetMapping("/comment")
    public ModelAndView comment(@RequestParam("topic_id") int topic_id, Model model){
        List<Comment> comments = commentService.selectComments(topic_id);
        List<Comment> comments1 = new ArrayList<>();
        ModelAndView success = new ModelAndView();
        for (Comment comment:comments){
            Comment comment2 = new Comment(topic_id,comment.getUsername(),comment.getComment());
            comments1.add(comment2);
        }
        model.addAttribute("comments",comments1);
        success.setViewName("comment");
        return success;
    }
    @RequestMapping(value = "/insertQuestion", method = RequestMethod.GET)
    public Question insert(Question question) {
        return questionService.save(question);
    }
    @RequestMapping(value = "/insertComment", method = RequestMethod.GET)
    public Comment insert(Comment comment) {
        return commentService.save(comment);
    }


    @GetMapping("/home")
    public ModelAndView home(Model model){
        ModelAndView success = new ModelAndView();

        List<Comment> tempcomments = new ArrayList<>();

        List<Question> questions = questionService.selectbyusername(Hostname);
        for (Question question:questions){
            System.out.println(question.getTopic_id());
            tempcomments.addAll(commentService.selectComments(question.getTopic_id()));
        }
        model.addAttribute("questions1",questions);
        model.addAttribute("comments1",tempcomments);
        List<Comment> comments = commentService.selectbyusername(Hostname);
        model.addAttribute("comments2",comments);
        success.setViewName("home");
        return success;
    }
    //删除问题
    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String delete(int topic_id) {
        int result = questionService.deleteById(topic_id);
        String name = questionService.selectById(topic_id).getUsername();
        if (result >= 1 && Objects.equals(name, Hostname)) {
            return "删除成功";
        } else {
            return "删除失败";
        }
    }
    @RequestMapping(value = "/delete1", method = RequestMethod.GET)
    public String delete1(int topic_id) {
        int result = commentService.deleteById(topic_id);
        if (result >= 1) {
            return "删除成功";
        } else {
            return "删除失败";
        }
    }
}