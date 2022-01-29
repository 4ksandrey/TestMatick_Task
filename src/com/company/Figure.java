package com.company;

import java.util.Random;

public abstract class Figure {

    public abstract String getName();

    public abstract double getArea();

    public abstract String getUnique();

    public abstract String getColor();

    public static Figure random() {
        Random random = new Random();
        Figure f;
        int rand = random.nextInt(4);
        switch (rand) {
            case 0:
                f = new Square(Math.random() * 20);
                break;
            case 1:
                f = new Circle(Math.random() * 20);
                break;
            case 2:
                f = new Triangle(Math.random() * 20, Math.random() * 20, Math.random() * 20);
                break;
            case 3:
                f = new Trapezoid(Math.random() * 20, Math.random() * 20, Math.random() * 20, Math.random() * 20);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + rand);
        }
        return f;
    }
}

class Circle extends Figure {

    private static final String Name = "Circle";
    private final double radius;
    private static final String Color = "Green";

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public String getUnique() {
        String s = "Диаметр круга: ";
        return s + (radius+radius);
    }

    @Override
    public String getName() {
        return Name;
    }

    @Override
    public String getColor() {
        return Color;
    }

}

class Square extends Figure {

    private static final String Name = "Square";
    private static final String Color = "Blue";
    private final double a;

    public Square(double a) {
        this.a = a;
    }

    @Override
    public String getName() {
        return Name;
    }

    @Override
    public double getArea() {
        return a * a;
    }

    @Override
    public String getUnique() {
        String s = "Диагональ квадрата: ";
        return s + (a * Math.sqrt(2));
    }

    @Override
    public String getColor() {
        return Color;
    }
}

class Triangle extends Figure {

    private static final String Name = "Triangle";
    private static final String Color = "Red";
    private final double a;
    private final double b;
    private final double c;

    public Triangle(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public String getName() {
        return Name;
    }

    @Override
    public double getArea() {
        double p = (a + b + c) / 2;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }

    @Override
    public String getUnique() {
        String s = "Радиус описаной окружности: ";
        return s + a*b*c /(getArea() * 4);
    }

    @Override
    public String getColor() {
        return Color;
    }
}

class Trapezoid extends Figure {

    private static final String Name = "Trapezoid";
    private static final String Color = "Yellow";
    private final double a; //нижнее основание
    private final double b; //верхнее основание
    private final double c; //левая сторона
    private final double d; //правая сторона

    public Trapezoid(double a, double b, double c, double d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    @Override
    public String getName() {
        return Name;
    }

    @Override
    public double getArea() {
        return (a + b) / 2 * Math.sqrt(c*c - Math.pow(((Math.pow((a-b),2) + c*c - d*d) / (2*(a-b))), 2));
    }

    @Override
    public String getUnique() {
        String s = "Средняя линия трапеции: ";
        return s + (a + b) / 2;
    }

    @Override
    public String getColor() {
        return Color;
    }
}