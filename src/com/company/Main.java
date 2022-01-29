package com.company;

public class Main {

    public static void main(String[] args) {

        Figure[] figure = new Figure[(int) (Math.random()*20)];
        for (int i = 0; i < figure.length; i++) figure[i] = Figure.random();
        for(Figure fig : figure)
            System.out.println("Фигура: " + fig.getName() + ", площадь: " + fig.getArea() + " кв.ед., " + fig.getUnique() + ", Цвет: " + fig.getColor());

    }

}
