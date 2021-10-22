import java.nio.charset.Charset;
import com.googlecode.lanterna.TerminalFacade;
import com.googlecode.lanterna.gui.*;
import com.googlecode.lanterna.gui.Component.Alignment;
import com.googlecode.lanterna.gui.component.Button;
import com.googlecode.lanterna.gui.component.EmptySpace;
import com.googlecode.lanterna.gui.component.Label;
import com.googlecode.lanterna.gui.component.Panel;
import com.googlecode.lanterna.gui.component.Panel.Orientation;
import com.googlecode.lanterna.gui.component.Table;
import com.googlecode.lanterna.gui.layout.LinearLayout;
import com.googlecode.lanterna.gui.layout.VerticalLayout;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.ScreenCharacterStyle;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.TerminalSize;

public class Kasa_kinowa {
    public static void start() {
        Screen screen = TerminalFacade.createScreen();
        screen.getTerminalSize();
        screen.readInput();
        screen.startScreen();
        screen.putString(4, 4, "Witam studenta ponownie!", Terminal.Color.BLUE, Terminal.Color.BLACK, ScreenCharacterStyle.Bold);
//false, false, false);
        screen.refresh();

        screen.putString(4, 6, "Witam studenta ponownie!", Terminal.Color.BLUE, Terminal.Color.BLACK, ScreenCharacterStyle.Bold);
//false, false, false);
        screen.refresh();
        Thread.currentThread();
        while(screen.readInput()==null){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        screen.stopScreen();
    }

    public static void main(String[] args) {
        start();
    }
}
