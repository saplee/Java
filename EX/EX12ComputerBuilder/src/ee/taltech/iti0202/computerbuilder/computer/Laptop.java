package ee.taltech.iti0202.computerbuilder.computer;

import ee.taltech.iti0202.computerbuilder.components.Component;
import ee.taltech.iti0202.computerbuilder.exceptions.CannotBuildComputer;

import java.util.List;

public class Laptop extends Computer {
    public Laptop(List<Component> components) throws CannotBuildComputer {
        super(components);
    }
}
