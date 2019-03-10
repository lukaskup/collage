public class GUI0101 {

    public static void main(String[] args) {

        Rect zp[] = {
                new Rect(4, 'a', 'e'),
                new Rect(5, 3, '*', '+'),
                new Rect(1, 2, 'a','a'),
                new Rect(3, 3, '+', 'x'),
                new Rect(1, 2, 'x', 'y'),
                new Rect(3, 4, '^', '$')
        };

        for (Rect z : zp)
            try {
                if(z.width == z.height){
                    System.out.print("Square ");
                }else{
                    System.out.print("Rectangle ");
                }

                System.out.print("("+ z.id +") ");
                System.out.print("size " + z.width + " x " + z.height);

                if(z.char1 == z.char2){
                    System.out.print(", " + z.char1 + "=" + z.in);
                }else{
                    System.out.print(", " + z.char1 + "=" + z.in);
                    System.out.print(", " + z.char2+ "=" + z.out);
                }
                System.out.println("");
                if(z.width < 0 || z.height < 0) throw new RectException("Wrong rectangle");

                if(z.width == 1 || z.height == 1){
                    if(z.char1 != z.char2){
                        throw new RectException("Wrong reactangle");
                    }
                }else{
                    if(z.char1 == z.char2){
                        throw new RectException("Wrong rectangle");
                    }
                }

                z.rysuj();
            } catch(RectException e) {
                System.out.println(e.getMessage());
            }
    }
}

class Rect{
    static int sumRect = 0;
    static int sumSquare = 0;
    public int id;
    public int width;
    public int height;
    public char char1;
    public char char2;
    public int out;
    public int in;

    Rect(int width, int height, char char1, char char2){

        if(width == height){
            sumSquare++;
            this.id = sumSquare;
        } else {
            sumRect++;
            this.id = sumRect;
        }
        this.width = width;
        this.height = height;
        this.char1 = char1;
        this.char2 = char2;

        this.out = (2 * this.width) +  (2 * this.height) - 4;
        this.in = (this.height * this.width) - this.out;
    }

    Rect(int width, char char1, char char2){
        this(width, width, char1, char2);
    }

    public void rysuj(){
        for(int i = 0; i < height; i++){
            for(int i2 = 0; i2 < width; i2++){
                if(i == 0 || i == height - 1){
                    System.out.print(char2);
                }else{
                    if(i2 == 0 || i2 == width - 1){
                        System.out.print(char2);
                    }else{
                        System.out.print(char1);
                    }
                }
            }
            System.out.println("");
        }
        System.out.println("");
    }
}

class RectException extends Exception {
    public RectException(String errorMessage) {
        super(errorMessage);
    }
}