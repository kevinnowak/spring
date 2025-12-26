package com.github.kevinnowak.springshell;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.util.unit.DataSize;

@ShellComponent
class FsCommands {

    private final FileSystem fs;

    FsCommands(FileSystem fs) {
        this.fs = fs;
    }

    @ShellMethod("Display required free disk space")
    public long minimumFreeDiskSpace() {
        return 1_000_000;
    }

    @ShellMethod("Convert to lowercase string")
    public String toLowercase(String input) {
        return input.toLowerCase();
    }

    @ShellMethod("Display free disk space")
    public String freeDiskSpace() {
        return DataSize.ofBytes(fs.getFreeDiskSpace()).toGigabytes() + " GB";
    }
}
