package com.usedcar.controller;

import cn.hutool.core.map.MapUtil;
import com.google.code.kaptcha.Producer;
import com.usedcar.common.lang.Const;
import com.usedcar.common.lang.Result;
import com.usedcar.entity.SysUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import sun.misc.BASE64Encoder;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.Principal;

import cn.hutool.core.lang.UUID;
/**
 * @author Kunlong Wang
 * @create 2021-11-21 22:20
 */
@Slf4j
@RestController
public class AuthController extends BaseController{
    @Autowired
    Producer producer;
    /**
     * verification code
     */
    @GetMapping("/getCaptcha")
    public Result captcha(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String code = producer.createText();
        String key = UUID.randomUUID().toString();

        BufferedImage image = producer.createImage(code);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        // image verification code
        ImageIO.write(image, "jpg", outputStream);
        BASE64Encoder encoder = new BASE64Encoder();
        String str = "data:image/jpeg;base64,";
        String base64Img = str + encoder.encode(outputStream.toByteArray());

        // Store in redis
        redisUtil.hset(Const.CAPTCHA_KEY, key, code, 120);
        log.info("verification code ------------ {} - {}", key, code);
        return Result.succ(
                MapUtil.builder()
                        .put("token", key)
                        .put("base64Img", base64Img)
                        .build()
        );
    }

    @GetMapping("/sys/userInfo")
    public Result userInfo(Principal principal) {
        SysUser sysUser = sysUserService.getByUsername(principal.getName());
        return Result.succ(MapUtil.builder()
                .put("id", sysUser.getId())
                .put("username", sysUser.getUsername())
                .put("created", sysUser.getCreated())
                .map()
        );
    }
}
