/*
 *  Brick Destroy - A simple Arcade video game
 *   Copyright (C) 2017  Filippo Ranza
 *
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package game;

import view.GameFrame;

import java.awt.*;

/**
 * This is the Main Class of Brick Breaker game.
 * @author Heng Yuen Qi
 * @version 2.0
 * @since 30/11/2021
 */
public class GraphicsMain {

    /**
     * This is the starting point for JVM to start execution of a Java program.
     * It creates GameFrame object and initialise it accordingly.
     *
     * @param args command line arguments in the form of string values
     */
    public static void main(String[] args){
        EventQueue.invokeLater(() -> new GameFrame().initialize());
    }

}