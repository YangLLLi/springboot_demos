package github.yangllli.springboot_demos.springMVC;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Controller主要用来处理请求，返回model和视图名
 * 涉及路径路由@requestMapping
 * 请求参数@PathVariable、@RequestParam、@RequestPart、@RequestBody
 * 模型 model以及 session context
 * 返回的视图名 return    redirect/forward
 */

@Controller
public class ControllerDemo {

    @RequestMapping("/demo/{msg}")
    public String demo1(@PathVariable String msg, Model model) {
        model.addAttribute("msg", msg);
        return "demo";
    }

    //forward服务器转发
//    redirect重定向
    @RequestMapping("/demo")
    //路径如/demo?msg=1
    public String demo2(@RequestParam String msg) {
        return "forward:/demo/" + msg;
//        return "redirect:/demo/"+msg;
    }

    @RequestMapping("/demo/part")
    public String demoPart(@RequestPart MultipartFile file) throws IOException {
        Path path = Paths.get("D:\\Yang\\Pictures");
        String name = file.getOriginalFilename();
        Path resolve = path.resolve(name);
        file.transferTo(resolve);
        return "redirect:/demo/ok";
    }

    @RequestMapping("/demo/body")
    public String demoBody(@RequestBody String test) {
        return "redirect:/demo/" + test;
    }
}
