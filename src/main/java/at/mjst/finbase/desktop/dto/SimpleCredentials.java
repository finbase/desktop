/*
 * Copyright (c) 2017, Ing. Michael J. Stallinger and/or his affiliates. All rights reserved.
 * This source code is subject to license terms, see the LICENSE file for details.
 */
package at.mjst.finbase.desktop.dto;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

/**
 * ToDo: Short class description
 *
 * @author Ing. Michael J. Stallinger (projects@mjst.at)
 * @since 2017-01-05
 */
public final class SimpleCredentials implements Credentials
{
    /**
     * Username (typically provided by user)
     */
    private final String userName;
    /**
     * Password (never store!)
     */
    private final String password;

    /**
     * @param userName the user name
     * @param password password stored in plain text
     */
    private SimpleCredentials(@NotNull String userName, @NotNull String password)
    {
        this.userName = userName;
        this.password = password;
    }

    /**
     * @param userName the user name
     * @param password password stored in plain text
     * @return a new instance of SimpleCredentials
     */
    @NotNull
    public static Credentials create(@NotNull String userName, @NotNull String password)
    {
        return new SimpleCredentials(userName, password);
    }

    @Override
    public boolean valid()
    {
        return (!(isUserNameEmpty() || isPasswordEmpty()));
    }

    @Contract(pure = true)
    @Override
    public String getUserName()
    {
        return userName;
    }

    @Contract(pure = true)
    @Override
    public boolean isUserNameEmpty()
    {
        return userName.isEmpty();
    }

    @Contract(pure = true)
    @Override
    public String getPassword()
    {
        return password;
    }

    @Override
    public boolean isPasswordEmpty()
    {
        return (getPassword().isEmpty());
    }
}
