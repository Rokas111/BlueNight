package me.Rokaz.BlueCraft.core.lib.command;

import java.util.Arrays;
import java.util.List;

public abstract class Command implements ICommand {
    private RequiredPermission p;
    private List<String> aliases;
    private List<String> usages;
    public Command(RequiredPermission p,List<String> usages, String... aliases) {
        this.p = p;
        this.usages = usages;
        this.aliases = Arrays.asList(aliases);
    }
    public RequiredPermission getPermission() {
        return this.p;
    }
    public List<String> getUsages() { return this.usages;}
    public List<String> getAliases() {
        return this.aliases;
    }

}
