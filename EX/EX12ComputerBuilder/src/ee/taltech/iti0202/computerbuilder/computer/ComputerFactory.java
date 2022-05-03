package ee.taltech.iti0202.computerbuilder.computer;


import ee.taltech.iti0202.computerbuilder.Customer;
import ee.taltech.iti0202.computerbuilder.components.Component;
import ee.taltech.iti0202.computerbuilder.database.Database;
import ee.taltech.iti0202.computerbuilder.exceptions.CannotBuildComputer;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ComputerFactory {
    private static Database database = Database.getInstance();
    private static double number1 = 140.0;
    private static double number2 = 12.0;
    private static double number3 = 9.0;

    public static List<Component> getAvailableComponents() {
        List<Component> componentList = database.getComponents().values().stream().toList();
        List<Component> result = new ArrayList<>();
        for (Component component : componentList) {
            if (component.getAmount() > 0) {
                result.add(component);
            }
        }
        return result;
    }

    public static Component getBestComponent(float maxPrice, Component.Type type) throws CannotBuildComputer {
        List<Component> bestComponents = getAvailableComponents().stream().filter(component -> component.getType().
                        equals(type)).filter(component -> component.getPrice().
                        floatValue() <= maxPrice).toList().stream()
                .sorted(Comparator.comparing(Component::getPerformancePoints).reversed()).toList();
        if (bestComponents.size() == 0) {
            throw new CannotBuildComputer();
        } else {
            return bestComponents.get(0);
        }
    }

    public static Component getPsu(float maxPrice, List<Component> components) throws CannotBuildComputer {
        List<Integer> integers = components.stream().map(Component::getPowerConsumption).toList();
        Integer sum = integers.stream().reduce(0, Integer::sum);
        List<Component> bestPsu = getAvailableComponents().stream().filter(component -> component.getType().
                        equals(Component.Type.PSU)).filter(component -> component.getPrice().
                        floatValue() <= maxPrice).filter(component -> component.getPowerConsumption() >= sum)
                .toList().stream()
                .sorted(Comparator.comparing(Component::getPerformancePoints).reversed()).toList();
        if (bestPsu.size() == 0) {
            throw new CannotBuildComputer();
        } else {
            return bestPsu.get(0);
        }
    }

    public static Component getHddOrSsd(float maxPrice) throws CannotBuildComputer {
        List<Component> allSdd = getAvailableComponents().stream().filter(component -> component.getType().
                        equals(Component.Type.SSD)).filter(component -> component.getPrice().
                        floatValue() <= maxPrice).toList().stream()
                .sorted(Comparator.comparing(Component::getPerformancePoints).reversed()).toList();
        List<Component> allHdd = getAvailableComponents().stream().filter(component -> component.getType().
                        equals(Component.Type.HDD)).filter(component -> component.getPrice().
                        floatValue() <= maxPrice).toList().stream()
                .sorted(Comparator.comparing(Component::getPerformancePoints).reversed()).toList();
        List<Component> bestHddOrSsd = new ArrayList<>();
        bestHddOrSsd.addAll(allHdd);
        bestHddOrSsd.addAll(allSdd);
        if (bestHddOrSsd.size() == 0) {
            throw new CannotBuildComputer();
        } else {
            return bestHddOrSsd.stream().sorted(Comparator.comparing(Component::getPerformancePoints).reversed())
                    .toList().get(0);
        }
    }

    public static Computer order(ComputerType computerType, UseCase useCase, Customer customer)
            throws CannotBuildComputer {
        List<Component> result = new ArrayList<>();
        int budget = customer.getBalance().intValue();
        float gpuMaxPrice = 0;
        float cpuMaxPrice = 0;
        float psuMaxPrice = 0;
        float ramMaxPrice = 0;
        float caseMaxPrice = 0;
        float storageMaxPrice = 0;
        float motherboardMaxPrice = 0;
        float keyboardMaxPrice = 0;
        float screenMaxPrice = 0;
        if (computerType.equals(ComputerType.DESKTOP)) {
            if (useCase.equals(UseCase.GAMING)) {
                gpuMaxPrice = (float) (1. / 3. * budget);
                cpuMaxPrice = (float) (0.25 * budget);
                psuMaxPrice = (float) (1. / number2 * budget);
                ramMaxPrice = (float) (1.0 / number2 * budget);
                motherboardMaxPrice = (float) (1.0 / number2 * budget);
                caseMaxPrice = (float) (1.0 / number2 * budget);
                storageMaxPrice = (float) (1.0 / number2 * budget);
            } else if (useCase.equals(UseCase.WORK)) {
                gpuMaxPrice = (float) (1.0 / 4.0 * budget);
                cpuMaxPrice = (float) (1.0 / 3.0 * budget);
                psuMaxPrice = (float) (1.0 / number2 * budget);
                ramMaxPrice = (float) (1.0 / number2 * budget);
                motherboardMaxPrice = (float) (1.0 / number2 * budget);
                caseMaxPrice = (float) (1.0 / number2 * budget);
                storageMaxPrice = (float) (1.0 / number2 * budget);
            }
            result.add(getBestComponent(gpuMaxPrice, Component.Type.GPU));
            result.add(getBestComponent(cpuMaxPrice, Component.Type.CPU));
            result.add(getBestComponent(motherboardMaxPrice, Component.Type.MOTHERBOARD));
            result.add(getBestComponent(ramMaxPrice, Component.Type.RAM));
            result.add(getBestComponent(caseMaxPrice, Component.Type.CASE));
            result.add(getHddOrSsd(storageMaxPrice));
            result.add(getPsu(psuMaxPrice, result));
            Desktop desktop = new Desktop(result);
            customer.addComputer(desktop);
            return desktop;

        } else {
            if (useCase.equals(UseCase.WORK)) {
                gpuMaxPrice = (float) (1.0 / 4.0 * budget);
                cpuMaxPrice = (float) (1.0 / 3.0 * budget);
                psuMaxPrice = (float) (number3 / number1 * budget);
                ramMaxPrice = (float) (number3 / number1 * budget);
                motherboardMaxPrice = (float) (number3 / number1 * budget);
                caseMaxPrice = (float) (number3 / number1 * budget);
                storageMaxPrice = (float) (number3 / number1 * budget);
                keyboardMaxPrice = (float) (number3 / number1 * budget);
                screenMaxPrice = (float) (number3 / number1 * budget);
            } else if (useCase.equals(UseCase.GAMING)) {
                gpuMaxPrice = (float) (1.0 / 3.0 * budget);
                cpuMaxPrice = (float) (1.0 / 4.0 * budget);
                psuMaxPrice = (float) (number3 / number1 * budget);
                ramMaxPrice = (float) (number3 / number1 * budget);
                motherboardMaxPrice = (float) (number3 / number1 * budget);
                caseMaxPrice = (float) (number3 / number1 * budget);
                storageMaxPrice = (float) (number3 / number1 * budget);
                keyboardMaxPrice = (float) (number3 / number1 * budget);
                screenMaxPrice = (float) (number3 / number1 * budget);
            }
            result.add(getBestComponent(gpuMaxPrice, Component.Type.GPU));
            result.add(getBestComponent(cpuMaxPrice, Component.Type.CPU));
            result.add(getBestComponent(motherboardMaxPrice, Component.Type.MOTHERBOARD));
            result.add(getBestComponent(ramMaxPrice, Component.Type.RAM));
            result.add(getBestComponent(caseMaxPrice, Component.Type.CASE));
            result.add(getHddOrSsd(storageMaxPrice));
            result.add(getBestComponent(keyboardMaxPrice, Component.Type.KEYBOARD));
            result.add(getBestComponent(screenMaxPrice, Component.Type.SCREEN));
            result.add(getPsu(psuMaxPrice, result));
            Laptop laptop = new Laptop(result);
            customer.addComputer(laptop);
            return laptop;
        }
    }
}
