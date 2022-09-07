package homework4;

import lesson4.BoxIsEmptyExeption;

import java.util.Arrays;

public class AreaTriangle {

    public double calculateAreaTriangle(Integer[] array) throws SideTriangleIsNull, NoSuchTriangle {

        for (int i = 0; i < array.length; i++){
            if (array[0] <= 0 || array[1] <= 0|| array[2] <= 0){
                throw new SideTriangleIsNull();
            }

            double a = array[0];
            double b = array[1];
            double c = array[2];

            //сумма двух сторон больше не должна быть меньше чем длина третьей стороны
            if (a + b <= c || a + c <= b || b + c < a){
                throw new NoSuchTriangle();
            }
        }
            Integer halfMeter = (array[0] + array[1] + array[2]) / 2;
            Integer area = (halfMeter * (halfMeter - array[0]) * (halfMeter - array[1]) * (halfMeter - array[2]));
            double square = Math.sqrt(area);
            return square;
    }

}
