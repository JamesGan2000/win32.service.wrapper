package com.xyz.jna.win32.service.wrapper;

import com.sun.jna.Native;
import com.sun.jna.Pointer;
import com.sun.jna.platform.win32.WinDef;
import com.sun.jna.platform.win32.WinUser;

import java.util.ArrayList;
import java.util.List;

public class WindowInfoWrapper implements WinUser.WNDENUMPROC {
    int count = 0;
    private List<String> windowInfo = new ArrayList<>();

    public boolean callback(WinDef.HWND hWnd, Pointer arg1) {
        final Win32WrapperService.User32 user32 = Win32WrapperService.User32.INSTANCE;

        byte[] windowText = new byte[1024];
        user32.GetWindowTextA(hWnd, windowText, windowText.length);
        String wText = Native.toString(windowText);

        if (wText.isEmpty()) {
            return true;
        }

        windowInfo.add("Window, hwnd:" + hWnd + ", # " + ++count + " Title: " + wText);

        return true;
    }

    public List<String> getWindowInfo() {
        return windowInfo;
    }

    public void resetInfo(){
        count = 0;
        windowInfo = new ArrayList<>();
    }
}
