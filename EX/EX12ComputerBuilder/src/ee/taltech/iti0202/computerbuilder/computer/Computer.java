package ee.taltech.iti0202.computerbuilder.computer;

import ee.taltech.iti0202.computerbuilder.components.Component;
import ee.taltech.iti0202.computerbuilder.exceptions.CannotBuildComputer;

import java.util.List;

public abstract class Computer {
    protected List<Component> components;


    public Computer(List<Component> components) throws CannotBuildComputer {
        this.components = components;
    }

    public List<Component> getComponents() {
        return components;
    }
}
