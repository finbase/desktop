/*
 * Copyright (c) 2017, Ing. Michael J. Stallinger and/or his affiliates. All rights reserved.
 * This source code is subject to license terms, see the LICENSE file for details.
 */
package at.mjst.finbase.desktop.model.entity.field;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ObservableValue;

/**
 * Wrapper around instances of {@link ObservableValue<>} to enable
 * enumeration of {@link at.mjst.finbase.desktop.model.entity.Entity}-columns.
 *
 * Note that instances of {@link AbstractField} are NOT injected by the DI-framework for performance considerations!
 *
 * @author Ing. Michael J. Stallinger (projects@mjst.at)
 * @since 2017-01-18
 */
public abstract class AbstractField<T> implements Field<T>
{
    /**
     * The property to be wrapped
     */
    private ObjectProperty<T> property;
    /**
     * This fields name
     */
    private String name;

    /**
     * Creates an instance of this class. The property-attribute is created internally.
     *
     * @param fieldName The fields fieldName
     */
    AbstractField(String fieldName)
    {
        this(fieldName, new SimpleObjectProperty<>());
    }

    /**
     * Creates an instance of this class
     *
     * @param fieldName The fields name
     * @param property  ObjectProperty to be wrapped
     */
    AbstractField(String fieldName, ObjectProperty<T> property)
    {
        this.name = fieldName;
        this.property = property;
    }

    /**
     * @return this fields name
     */
    @Override
    public String getName()
    {
        return name;
    }

    /**
     * @return {@link ObservableValue<>} interface of {@link #property}
     */
    @Override
    public ObservableValue<T> getObservableValue()
    {
        return property;
    }

    /**
     * @return the value of type <T>
     */
    @Override
    public T getValue()
    {
        return property.get();
    }

    /**
     * Sets value of type T
     *
     * @param value T
     */
    @Override
    public void setValue(T value)
    {
        property.set(value);
    }

    /**
     * @return a string representation of the object
     */
    @Override
    public String toString()
    {
        return String.valueOf(property.get());
    }
}