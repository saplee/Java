package ee.taltech.iti0202.mysticorbs.oven;

import ee.taltech.iti0202.mysticorbs.exceptions.CannotFixException;

/**
 *
 */
public interface Fixable {
    public void fix() throws CannotFixException;

    public int getTimesFixed();
}
