package com.example.demo222.controller;

import com.example.demo222.entity.*;
import com.example.demo222.service.LoginService;
import com.example.demo222.service.impl.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
public class MyController {
    String Hostname = null;
    Integer TopicID = null;
    Integer CommentID = null;
    @Autowired
    LoginService loginService;
    @Autowired
    QuestionServiceImpl questionService;
    @Autowired
    CommentServiceImpl commentService;
    @Autowired
    OpinionServiceImpl opinionService;
    @Autowired
    CollectionCountServiceImpl collectionCountService;
    @Autowired
    CollectionPersonServiceImpl collectionPersonService;
    @Autowired
    LikeCountServiceImpl likeCountService;
    @Autowired
    LikePersonServiceImpl likePersonService;
    @Autowired
    FansAndStarsServiceImpl fansAndStarsService;
    @Autowired
    FanCountServiceImpl fanCountService;
    @Autowired
    StarCountServiceImpl starCountService;

    ////这里是首先进入登陆页面，然后再进行其他的操作
    @RequestMapping("/")
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView("login");
        return mv;
    }

    @RequestMapping("/registers")
    public ModelAndView zhuce() {
        ModelAndView mv = new ModelAndView("register");
        return mv;
    }

    //登陆功能
    @PostMapping("/login")
    public ModelAndView Login(@RequestParam("username") String username, @RequestParam("userpassword") String userpassword, Model model) {
        Hostname = username;
        List<Login> login = loginService.findByUsernameAndUserpassword(username, userpassword);
        System.out.println(username + ":" + userpassword);
        ModelAndView success = new ModelAndView();
        if (login.size() > 0) {
            List<Question> questions = questionService.findAll();
            List<Question> questions1 = new ArrayList<>();
            int i = 1;
            for (Question question : questions) {
                Question question2 = new Question(i, question.getUsername(), question.getTitle());
                i++;
                questions1.add(question2);
            }
            model.addAttribute("questions", questions1);
            success.setViewName("success");
        } else {
            success.setViewName("404");
        }
        return success;
    }

    //注册功能
    @PostMapping("/register")
    public ModelAndView register(@RequestParam("username") String username, @RequestParam("password")
    String password, @RequestParam("password2") String password2, Model model) {
        Hostname = username;
        ModelAndView success = new ModelAndView();
        //用户或密码为空的条件判断
        if (username.isEmpty() || password.isEmpty() || password2.isEmpty()) {
            success.setViewName("register");
            success.addObject("tip1", "用户或密码不能为空");
            return success;
        }
        //两次密码不一样的判断条件
        if (!password.equals(password2)) {
            success.setViewName("register");
            success.addObject("tip2", "两次密码不一样");
            return success;
        }
        //判断是否取到用户，如果没有就保存在数据库中
        List<Login> us = loginService.findByUsername(username);
        if (us.size() == 0) {
            Login registers = new Login();
            registers.setUserpassword(password);
            registers.setUsername(username);
            List<Question> questions3 = questionService.findAll();
            /*List<Question> questions4 = new ArrayList<>();
            int i=1;
            for (Question question:questions3){
                Question question2 = new Question(i,question.getUsername(),question.getTitle());
                i++;
                questions4.add(question2);
            }*/
            model.addAttribute("questions", questions3);
            loginService.save(registers);
            //添加粉丝和关注数
            Fan fan = new Fan(Hostname,0);
            fanCountService.insert(fan);
            Star star = new Star(Hostname,0);
            starCountService.insert(star);
            success.setViewName("success");
        } else {
            success.setViewName("404");
        }
        return success;
    }

    @GetMapping("/comment")
    public ModelAndView comment(@RequestParam("topicid") int topicid, Model model) {
        //保存topicid
        TopicID = topicid;

        List<Comment> comments = commentService.selectComments(topicid);
        //List<Comment> comments1 = new ArrayList<>();
        ModelAndView success = new ModelAndView();
        /*for (Comment comment:comments){
            Comment comment2 = new Comment(topicid,comment.getUsername(),comment.getComment());
            comments1.add(comment2);
        }*/
        model.addAttribute("comments", comments);

        List<LikeCount> likeCounts = likeCountService.selectbytopicid(TopicID);
        model.addAttribute("likeCounts", likeCounts);

        success.setViewName("comment");
        return success;
    }

    //为我的界面，里面有我的问题及回答，
    @GetMapping("/home")
    public ModelAndView home(Model model) {
        ModelAndView success = new ModelAndView();

        model.addAttribute("Hostname", Hostname);

        List<CollectionCount> collectionCounts = collectionCountService.selectbyusername(Hostname);
        model.addAttribute("collectionCounts", collectionCounts);

        List<CollectionPerson> collectionPeople = collectionPersonService.selectbyusername(Hostname);
        model.addAttribute("collectionPeoples", collectionPeople);

        List<LikeCount> likeCounts = likeCountService.selectbyusername(Hostname);
        model.addAttribute("likeCounts", likeCounts);

        List<Comment> tempcomments = new ArrayList<>();

        List<Question> questions = questionService.selectbyusername(Hostname);
        for (Question question : questions) {
            System.out.println(question.getTopicid());
            tempcomments.addAll(commentService.selectComments(question.getTopicid()));
        }
        model.addAttribute("questions1", questions);
        model.addAttribute("comments1", tempcomments);

        List<Comment> comments = commentService.selectbyusername(Hostname);
        model.addAttribute("comments2", comments);

        List<Opinion> opinions = opinionService.selectByUsername(Hostname);
        model.addAttribute("opinions", opinions);

        success.setViewName("home");
        return success;
    }
    //粉丝界面
    @GetMapping("/fans")
    public ModelAndView fans(Model model){
        ModelAndView success = new ModelAndView();
        Star star = starCountService.selectByStarname(Hostname);
        model.addAttribute("name",star.getStarname());
        model.addAttribute("count",star.getCount());
        List<FansAndStars> fansAndStars = fansAndStarsService.selectbystarname(Hostname);
        model.addAttribute("fans",fansAndStars);
        success.setViewName("fans");
        return success;
    }
    //关注界面
    @GetMapping("/stars")
    public ModelAndView stars(Model model){
        ModelAndView success = new ModelAndView();
        Fan fan = fanCountService.selectByFanname(Hostname);
        model.addAttribute("name",fan.getFanname());
        model.addAttribute("count",fan.getCount());
        List<FansAndStars> fansAndStars = fansAndStarsService.selectbyfanname(Hostname);
        model.addAttribute("stars",fansAndStars);
        success.setViewName("stars");
        return success;
    }
    //添加关注
    @RequestMapping(value = "/addstarname", method = RequestMethod.GET)
    public String addstarname(String starname){
        FansAndStars fansAndStars = fansAndStarsService.selectbyname(new FansAndStars(starname,Hostname));
        if (fansAndStars==null){
            FansAndStars fansAndStars1 = new FansAndStars(starname,Hostname);
            fansAndStarsService.insert(fansAndStars1);
            fanCountService.update(new Fan(Hostname,fanCountService.selectByFanname(Hostname).getCount()+1));
            starCountService.update(new Star(starname,starCountService.selectByStarname(starname).getCount()+1));
            return "关注成功！";
        }else {
            return "你已经关注了！";
        }
    }
    //取消关注
    @RequestMapping(value = "/deletestar", method = RequestMethod.GET)
    public String deletestar(String starname){
        FansAndStars fansAndStars = fansAndStarsService.selectbyname(new FansAndStars(starname,Hostname));
        if (fansAndStars!=null){
            fansAndStarsService.delete(fansAndStars);
            fanCountService.update(new Fan(Hostname,fanCountService.selectByFanname(Hostname).getCount()-1));
            starCountService.update(new Star(starname,starCountService.selectByStarname(starname).getCount()-1));
            return "取消关注成功！";
        }else {
            return "取消关注失败，原因是没关注改这个人！";
        }
    }

    @GetMapping("/opinion")
    public ModelAndView opinion(@RequestParam("commentid") int commentid, Model model) {
        //保存commentid
        CommentID = commentid;

        List<Opinion> opinions = opinionService.selectOpinion(TopicID, commentid);
        ModelAndView success = new ModelAndView();
        model.addAttribute("opinions", opinions);
        success.setViewName("opinion");
        return success;
    }


    @RequestMapping(value = "/insertQuestion", method = RequestMethod.GET)
    public Question insert(Integer topicid,String title) {
        return questionService.save(new Question(topicid,Hostname,title));
    }


    @RequestMapping(value = "/insertComment", method = RequestMethod.GET)
    public Comment insert5(Integer commentid,String comment) {
        return commentService.save(new Comment(TopicID,commentid,Hostname,comment));
    }


    //删除问题
    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String delete(int topicid) {
        String name = questionService.selectById(topicid).getUsername();
        if (Objects.equals(name, Hostname)) {
            int result = questionService.deleteById(topicid);
            commentService.deleteById1(topicid);
            if (result >= 1) {
                return "删除成功";
            } else {
                return "删除失败";
            }

        } else {
            return "这个问题不是你写的！";
        }
    }

    //删除评论
    @RequestMapping(value = "/delete1", method = RequestMethod.GET)
    public String delete1(int topicid, int commentid) {
        String name = commentService.selectbyid(topicid, commentid).getUsername();
        if (Objects.equals(name, Hostname)) {
            int result = commentService.deleteById(topicid, commentid);
            if (result >= 1) {
                opinionService.deleteById1(topicid, commentid);
                return "删除成功";
            }
            return "删除失败";
        } else {
            return "这个评论不是你写的！";
        }
    }

    //删除评论的看法
    @RequestMapping(value = "/delete2", method = RequestMethod.GET)
    public String delete2(int topicid, int commentid, int opinionid) {
        int result = opinionService.deleteById(topicid, commentid, opinionid);
        return result >= 1 ? "删除成功" : "删除成功";
    }
    //删除收藏
    @RequestMapping(value = "/delete3", method = RequestMethod.GET)
    public String delete3(int topicid){
        CollectionPerson collectionPerson = collectionPersonService.selectById(topicid,Hostname);
        CollectionCount collectionCount = collectionCountService.selectById(topicid);
        if (collectionPerson!=null){
            collectionPersonService.delete(collectionPerson);
            if(collectionCount.getCount()-1==0){
                collectionCountService.delete(topicid,collectionCount.getUsername());
            }else {
                CollectionCount collectionCount1 = new CollectionCount(topicid,collectionCount.getUsername(),collectionCount.getCount()-1);
                collectionCountService.update(collectionCount1);
            }
            return "成功删除收藏！";
        }else {
            return "没有该收藏！";
        }
    }


    //添加评论的看法
    @RequestMapping(value = "/insertOpinion", method = RequestMethod.GET)
    public Opinion insert1(Integer opinionid, String opinion) {
        Opinion opinion1 = new Opinion(TopicID, CommentID, opinionid, Hostname, opinion);
        return opinionService.save(opinion1);
    }

    //收藏的添加和修改（包括收藏方和被收藏放的数据）
    @RequestMapping(value = "/collection", method = RequestMethod.GET)
    public String insert(int topicid) {
        CollectionPerson collectionPerson = collectionPersonService.selectById(topicid, Hostname);
        if (collectionPerson == null) {
            //修改被收藏用户的数据
            String username = questionService.selectById(topicid).getUsername();
            CollectionCount collectionCount = collectionCountService.selectById(topicid);
            CollectionCount collectionCount1;
            if (collectionCount != null) {
                collectionCount1 = new CollectionCount(topicid, username, collectionCount.getCount() + 1);
                collectionCountService.update(collectionCount1);
            } else {
                collectionCount1 = new CollectionCount(topicid, username, 1);
                collectionCountService.save(collectionCount1);
            }
            //添加收藏用户的数据
            CollectionPerson collectionPerson1 = new CollectionPerson(topicid, Hostname);
            collectionPersonService.insert(collectionPerson1);
            return "收藏成功！";
        } else {
            return "收藏失败！";
        }
    }

    //增加点赞
    @RequestMapping(value = "/like", method = RequestMethod.GET)
    public String insert1(int commentid) {
        LikePerson likePerson = likePersonService.selectById(TopicID, commentid, Hostname);
        if (likePerson == null) {
            String username = commentService.selectbyid(TopicID, commentid).getUsername();
            LikeCount likeCount = likeCountService.selectById(TopicID, commentid);
            LikeCount likeCount1;
            if (likeCount != null) {
                likeCount1 = new LikeCount(TopicID, commentid, username, likeCount.getCount() + 1);
                likeCountService.update(likeCount1);
            } else {
                likeCount1 = new LikeCount(TopicID, commentid, username, 1);
                likeCountService.save(likeCount1);
            }
            //添加点赞用户的数据
            LikePerson likePerson1 = new LikePerson(TopicID, commentid, Hostname);
            likePersonService.insert(likePerson1);
            return "点赞成功";
        } else {
            return "点赞失败";
        }
    }

    //删除点赞
    @RequestMapping(value = "/deletelike", method = RequestMethod.GET)
    public String delete4(int commentid) {
        LikePerson likePerson = likePersonService.selectById(TopicID, commentid, Hostname);
        LikeCount likeCount= likeCountService.selectById(TopicID,commentid);
        if (likePerson != null) {
            Integer Count = likeCount.getCount()-1;
            if (Count == 0){
                likeCountService.delete(TopicID,commentid);
            }else{
                LikeCount likeCount1 = new LikeCount(TopicID,commentid,likeCount.getUsername(),Count);
                likeCountService.update(likeCount1);
            }
            likePersonService.delete(likePerson);
            return "取消点赞成功！";
        } else {
            return "取消点赞失败，原因为该信息不存在！";
        }
    }
}