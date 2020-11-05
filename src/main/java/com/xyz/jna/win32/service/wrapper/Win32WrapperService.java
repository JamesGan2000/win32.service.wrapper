package com.xyz.jna.win32.service.wrapper;

import com.sun.jna.Native;
import com.sun.jna.Pointer;
import com.sun.jna.platform.win32.WinDef;
import com.sun.jna.platform.win32.WinUser;
import com.sun.jna.win32.StdCallLibrary;

import java.util.List;

public class Win32WrapperService {
    final User32 user32 = User32.INSTANCE;
    WindowInfoWrapper wrapper = new WindowInfoWrapper();

    public interface User32 extends StdCallLibrary {
        User32 INSTANCE = Native.loadLibrary("user32", User32.class);
        boolean EnumWindows(WinUser.WNDENUMPROC lpEnumFunc, Pointer arg);
        int GetWindowTextA(WinDef.HWND hWnd, byte[] lpString, int nMaxCount);
    }

    public List<String> listWindows(){
        wrapper.resetInfo();

        user32.EnumWindows(wrapper, null);

        return wrapper.getWindowInfo();
    }
}
