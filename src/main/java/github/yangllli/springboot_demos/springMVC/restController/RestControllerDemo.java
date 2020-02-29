package github.yangllli.springboot_demos.springMVC.restController;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * rest 资源的表述性状态转移
 * viewResolver和view被message converter代替，只传递数据（View去了前端）
 * <p>
 * 映射@GetMapping @PostMapping @DeleteMapping @PutMapping
 * 请求参数@PathVariable、@RequestParam、@RequestPart、@RequestBody
 * 模型 model以及 session context
 * 返回@ResponseBody responseEntity （@RestController表示返回都为@responseBody)
 */
@RestController
public class RestControllerDemo {
    @GetMapping("/restDemo/{msg}")
//    @ResponseBody
    public Map<String, String> demo1(@PathVariable String msg) {
        Map<String, String> map = new HashMap<>();
        map.put("1",msg);
        map.put("2", msg);
        return map;
    }
//    @PostMapping @DeleteMapping @PutMapping
}
