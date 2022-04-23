package ee.taltech.iti0202.computerbuilder.computer;

import ee.taltech.iti0202.computerbuilder.components.Component;
import ee.taltech.iti0202.computerbuilder.exceptions.CannotBuildComputer;

import java.util.List;

public class Computer {
    protected List<Component> components;


    public Computer(List<Component> components) throws CannotBuildComputer {
        this.components = components;
        canBuildComputer();
    }

    public List<Component> getComponents() {
        return components;
    }


    public void canBuildComputer() throws CannotBuildComputer {
        List<Component.Type> componentsTypes = components.stream().map(Component::getType).toList();
        if (!componentsTypes.contains(Component.Type.CASE)) {
            throw new CannotBuildComputer();
        } else if (!componentsTypes.contains(Component.Type.CPU)) {
            throw new CannotBuildComputer();
        } else if (!componentsTypes.contains(Component.Type.GPU)) {
            throw new CannotBuildComputer();
        } else if (!componentsTypes.contains(Component.Type.PSU)) {
            throw new CannotBuildComputer();
        } else if (!componentsTypes.contains(Component.Type.MOTHERBOARD)) {
            throw new CannotBuildComputer();
        } else if (!componentsTypes.contains(Component.Type.SSD) || !componentsTypes.contains(Component.Type.HDD)) {
            throw new CannotBuildComputer();
        } else if (!componentsTypes.contains(Component.Type.RAM)) {
            throw new CannotBuildComputer();
        }
    }
}
