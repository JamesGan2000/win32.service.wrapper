package com.xyz.jna.win32.service.wrapper;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class Win32WrapperController {
    private Win32WrapperService win32WrapperService = new Win32WrapperService();

    @GetMapping("/list-windows")
    @ResponseBody
    public List<String> listWindows(){
        return win32WrapperService.listWindows();
    }
}
