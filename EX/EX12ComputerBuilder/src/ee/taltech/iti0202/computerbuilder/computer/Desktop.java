package ee.taltech.iti0202.computerbuilder.computer;

import ee.taltech.iti0202.computerbuilder.components.Component;
import ee.taltech.iti0202.computerbuilder.exceptions.CannotBuildComputer;

import java.util.List;

public class Desktop extends Computer {

    public Desktop(List<Component> components) throws CannotBuildComputer {
        super(components);
    }
}
