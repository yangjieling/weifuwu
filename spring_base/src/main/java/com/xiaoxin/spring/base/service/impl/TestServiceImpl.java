package com.xiaoxin.spring.base.service.impl;

import com.xiaoxin.spring.base.service.TestService;
import com.xiaoxin.spring.common.utils.FileUtil;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements TestService {
    ThreadLocal<String> threadLocal = new ThreadLocal<>();
    @Override
    public void removeFile(String fileName, String oldPath, String newPath) {
        threadLocal.set(fileName);
        FileUtil.removeFile(fileName,oldPath,newPath);
    }

    public String getFileName(){
        return threadLocal.get()+"ThreadLocal";
    }
}
