package com.github.kevinnowak.date4u;

import com.github.kevinnowak.date4u.core.FileSystem;
import org.springframework.boot.SpringApplication;
import org.springframework.util.unit.DataSize;

public class Date4uApplication {

    static void main(String[] args) {
        var ctx = SpringApplication.run(Date4uConfiguration.class, args);

        FileSystem fs = ctx.getBean(FileSystem.class);
        System.out.println(DataSize.ofBytes(fs.getFreeDiskSpace()).toGigabytes() + " GB");
    }
}
