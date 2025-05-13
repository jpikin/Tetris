import java.awt.event.KeyEvent;


public class Tetris {

    private Field field;
    private Figure figure;
    private boolean isGameOver;

    static Tetris game;



    public Field getField() {
        return field;
    }

    public Figure getFigure() {
        return figure;
    }

    void step() {

    }

    void run() throws Exception {
        KeyboardObserver keyboardObserver = new KeyboardObserver();
        keyboardObserver.start();

        //выставляем начальное значение переменной "игра окончена" в ЛОЖЬ
        isGameOver = false;
        //создаем первую фигурку посередине сверху: x - половина ширины, y - 0.
        figure = FigureFactory.createRandomFigure(field.getWidth() / 2, 0);

        //пока игра не окончена
        while (!isGameOver) {
            //"наблюдатель" содержит события о нажатии клавиш?
            if (keyboardObserver.hasKeyEvents()) {
                //получить самое первое событие из очереди
                KeyEvent event = keyboardObserver.getEventFromTop();
                //Если равно символу 'q' - выйти из игры.
                if (event.getKeyChar() == 'q') return;
                //Если "стрелка влево" - сдвинуть фигурку влево
                if (event.getKeyCode() == KeyEvent.VK_LEFT)
                    figure.left();
                    //Если "стрелка вправо" - сдвинуть фигурку вправо
                else if (event.getKeyCode() == KeyEvent.VK_RIGHT)
                    figure.right();
                    //Если  код клавиши равен 12 ("цифра 5 на доп. клавиатуре") - повернуть фигурку
                else if (event.getKeyCode() == 12)
                    figure.rotate();
                    //Если "пробел" - фигурка падает вниз на максимум
                else if (event.getKeyCode() == KeyEvent.VK_SPACE)
                    figure.downMaximum();
            }

            step();             //делаем очередной шаг
            field.print();      //печатаем состояние "поля"
            Thread.sleep(300);}
    }

    public static void main(String[] args) throws Exception {
        game = new Tetris();
        game.run();
    }

}
