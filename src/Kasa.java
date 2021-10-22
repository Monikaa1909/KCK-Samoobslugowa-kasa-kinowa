import java.awt.*;
import java.awt.TextArea;

import com.googlecode.lanterna.TerminalFacade;
import com.googlecode.lanterna.gui.*;

import com.googlecode.lanterna.gui.Component;
import com.googlecode.lanterna.gui.Component.Alignment;
import com.googlecode.lanterna.gui.Window;
import com.googlecode.lanterna.gui.listener.ComponentListener;
import com.googlecode.lanterna.gui.listener.WindowListener;
import com.googlecode.lanterna.gui.dialog.TextInputDialog;
import com.googlecode.lanterna.gui.component.*;
import com.googlecode.lanterna.gui.component.Button;
import com.googlecode.lanterna.gui.component.Label;
import com.googlecode.lanterna.gui.component.Panel;
import com.googlecode.lanterna.gui.dialog.DialogResult;
import com.googlecode.lanterna.gui.dialog.ListSelectDialog;
import com.googlecode.lanterna.gui.dialog.MessageBox;
import com.googlecode.lanterna.gui.layout.LinearLayout;
import com.googlecode.lanterna.terminal.TerminalSize;
import com.googlecode.lanterna.gui.dialog.ListSelectDialog;
import com.googlecode.lanterna.gui.component.EditArea;
import com.googlecode.lanterna.gui.component.ActionListBox;

//import java.awt.event.WindowListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Kasa {
    static Date biletData = null;
    static String biletKategoria = null;
    static String biletFilm = null;

    final static GUIScreen guiScreen = TerminalFacade.createGUIScreen();
    final static Window window = new Window("Samoobsługowa kasa kinowa");

    static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY-MM-dd");

    public static void wyczyscDane() {
        biletData = null;
    }

    public static void wybierzGodzine(String categorie) {
        window.removeAllComponents();

        Panel panel = new Panel("Krok 4");
        Component text = new Label("Wybierz godzinę:");

        text.setAlignment(Component.Alignment.CENTER);
        panel.setAlignment(Component.Alignment.CENTER);

        panel.addComponent(new EmptySpace(), LinearLayout.GROWS_HORIZONTALLY);
        panel.addComponent(text, LinearLayout.GROWS_HORIZONTALLY);
        panel.addComponent(new EmptySpace(), LinearLayout.GROWS_HORIZONTALLY);

        window.addComponent(new EmptySpace(), LinearLayout.GROWS_HORIZONTALLY);
        window.addComponent(panel, LinearLayout.GROWS_HORIZONTALLY);

        // -----------------------------------------

        // --------------------------------------------------
        Button cancel = new Button("Anuluj zakup biletu", new Action() {
            public void doAction() {
                wyczyscDane();
                start();
            }
        });

        Button back = new Button("Cofnij", new Action() {
            public void doAction() {
                wybierzFilm(categorie);
            }
        });

        back.setAlignment(Component.Alignment.CENTER);
        cancel.setAlignment(Alignment.CENTER);

        Panel panel2 = new Panel();
        panel2.setAlignment(Alignment.CENTER);

        panel2.addComponent(back, LinearLayout.GROWS_HORIZONTALLY);
        panel2.addComponent(cancel, LinearLayout.GROWS_HORIZONTALLY);

        window.addComponent(new EmptySpace(), LinearLayout.GROWS_HORIZONTALLY);
        window.addComponent(panel2, LinearLayout.GROWS_HORIZONTALLY);
    }

    public static void wybierzKategorie() {
        window.removeAllComponents();

        Panel panel = new Panel("Krok 2");
        Component text = new Label("Wybierz kategorię, która Cię interesuje:");

        text.setAlignment(Component.Alignment.CENTER);
        panel.setAlignment(Component.Alignment.CENTER);

        panel.addComponent(new EmptySpace(), LinearLayout.GROWS_HORIZONTALLY);
        panel.addComponent(text, LinearLayout.GROWS_HORIZONTALLY);
        panel.addComponent(new EmptySpace(), LinearLayout.GROWS_HORIZONTALLY);

        window.addComponent(new EmptySpace(), LinearLayout.GROWS_HORIZONTALLY);
        window.addComponent(panel, LinearLayout.GROWS_HORIZONTALLY);

        // -----------------------------------------
        Button categorie1_button = new Button("Komedia", new Action() {
            public void doAction() {
                wybierzFilm("Komedia");
            }
        });
        categorie1_button.setAlignment(Component.Alignment.CENTER);
        panel.addComponent(categorie1_button, LinearLayout.GROWS_HORIZONTALLY);

        Button categorie2_button = new Button("Horror", new Action() {
            public void doAction() {
                wybierzFilm("Horror");
            }
        });
        categorie2_button.setAlignment(Component.Alignment.CENTER);
        panel.addComponent(categorie2_button, LinearLayout.GROWS_HORIZONTALLY);

        Button categorie3_button = new Button("Thriller", new Action() {
            public void doAction() {
                wybierzFilm("Thriller");
            }
        });
        categorie3_button.setAlignment(Component.Alignment.CENTER);
        panel.addComponent(categorie3_button, LinearLayout.GROWS_HORIZONTALLY);

        Button categorie4_button = new Button("Film romantyczny", new Action() {
            public void doAction() {
                wybierzFilm("Film Romantyczny");
            }
        });
        categorie4_button.setAlignment(Component.Alignment.CENTER);
        panel.addComponent(categorie4_button, LinearLayout.GROWS_HORIZONTALLY);

        Button categorie5_button = new Button("Film akcji", new Action() {
            public void doAction() {
                wybierzFilm("Film akcji");
            }
        });
        categorie5_button.setAlignment(Component.Alignment.CENTER);
        panel.addComponent(categorie5_button, LinearLayout.GROWS_HORIZONTALLY);

        Button categorie6_button = new Button("Sci-fi", new Action() {
            public void doAction() {
                wybierzFilm("Sci-fi");
            }
        });
        categorie6_button.setAlignment(Component.Alignment.CENTER);
        panel.addComponent(categorie6_button, LinearLayout.GROWS_HORIZONTALLY);
        // --------------------------------------------------
        Button cancel = new Button("Anuluj zakup biletu", new Action() {
            public void doAction() {
                wyczyscDane();
                start();
            }
        });

        Button back = new Button("Cofnij", new Action() {
            public void doAction() {
                wybierzDate();
            }
        });

        back.setAlignment(Component.Alignment.CENTER);
        cancel.setAlignment(Alignment.CENTER);


        Panel panel2 = new Panel();
        panel2.setAlignment(Alignment.CENTER);

        panel2.addComponent(back, LinearLayout.GROWS_HORIZONTALLY);
        panel2.addComponent(cancel, LinearLayout.GROWS_HORIZONTALLY);

        window.addComponent(new EmptySpace(), LinearLayout.GROWS_HORIZONTALLY);
        window.addComponent(panel2, LinearLayout.GROWS_HORIZONTALLY);
    }

    public static void wybierzFilm(String categorie) {
        window.removeAllComponents();

        Panel panel = new Panel("Krok 3");
        Component text = new Label("Wybierz film, który Cię interesuje:");

        text.setAlignment(Component.Alignment.CENTER);
        panel.setAlignment(Component.Alignment.CENTER);

        panel.addComponent(new EmptySpace(), LinearLayout.GROWS_HORIZONTALLY);
        panel.addComponent(text, LinearLayout.GROWS_HORIZONTALLY);
        panel.addComponent(new EmptySpace(), LinearLayout.GROWS_HORIZONTALLY);

        window.addComponent(new EmptySpace(), LinearLayout.GROWS_HORIZONTALLY);
        window.addComponent(panel, LinearLayout.GROWS_HORIZONTALLY);

        //----------------------------
        if (categorie.equals("Komedia")) {
            Button categorie1_button = new Button("Komedia1", new Action() {
                public void doAction() {
                    wybierzGodzine("Komedia");
                }
            });
            categorie1_button.setAlignment(Component.Alignment.CENTER);
            panel.addComponent(categorie1_button, LinearLayout.GROWS_HORIZONTALLY);

            Button categorie2_button = new Button("Komedia2", new Action() {
                public void doAction() {

                }
            });
            categorie2_button.setAlignment(Component.Alignment.CENTER);
            panel.addComponent(categorie2_button, LinearLayout.GROWS_HORIZONTALLY);

            Button categorie3_button = new Button("Komedia3", new Action() {
                public void doAction() {

                }
            });
            categorie3_button.setAlignment(Component.Alignment.CENTER);
            panel.addComponent(categorie3_button, LinearLayout.GROWS_HORIZONTALLY);

            Button categorie4_button = new Button("Komedia4", new Action() {
                public void doAction() {

                }
            });
            categorie4_button.setAlignment(Component.Alignment.CENTER);
            panel.addComponent(categorie4_button, LinearLayout.GROWS_HORIZONTALLY);

            Button categorie5_button = new Button("Komedia5", new Action() {
                public void doAction() {

                }
            });
            categorie5_button.setAlignment(Component.Alignment.CENTER);
            panel.addComponent(categorie5_button, LinearLayout.GROWS_HORIZONTALLY);
        }
        else if (categorie.equals("Horror")) {
            Button categorie1_button = new Button("Komedia1", new Action() {
                public void doAction() {

                }
            });
            categorie1_button.setAlignment(Component.Alignment.CENTER);
            panel.addComponent(categorie1_button, LinearLayout.GROWS_HORIZONTALLY);

            Button categorie2_button = new Button("Komedia2", new Action() {
                public void doAction() {

                }
            });
            categorie2_button.setAlignment(Component.Alignment.CENTER);
            panel.addComponent(categorie2_button, LinearLayout.GROWS_HORIZONTALLY);

            Button categorie3_button = new Button("Komedia3", new Action() {
                public void doAction() {

                }
            });
            categorie3_button.setAlignment(Component.Alignment.CENTER);
            panel.addComponent(categorie3_button, LinearLayout.GROWS_HORIZONTALLY);

            Button categorie4_button = new Button("Komedia4", new Action() {
                public void doAction() {

                }
            });
            categorie4_button.setAlignment(Component.Alignment.CENTER);
            panel.addComponent(categorie4_button, LinearLayout.GROWS_HORIZONTALLY);

            Button categorie5_button = new Button("Komedia5", new Action() {
                public void doAction() {

                }
            });
            categorie5_button.setAlignment(Component.Alignment.CENTER);
            panel.addComponent(categorie5_button, LinearLayout.GROWS_HORIZONTALLY);
        }
        // dodać pozostałe kategorie


        //----------------------------
        Button cancel = new Button("Anuluj zakup biletu", new Action() {
            public void doAction() {
                wyczyscDane();
                start();
            }
        });

        Button back = new Button("Cofnij", new Action() {
            public void doAction() {
                wybierzKategorie();
            }
        });

        back.setAlignment(Component.Alignment.CENTER);
        cancel.setAlignment(Alignment.CENTER);


        Panel panel2 = new Panel();
        panel2.setAlignment(Alignment.CENTER);

        panel2.addComponent(back, LinearLayout.GROWS_HORIZONTALLY);
        panel2.addComponent(cancel, LinearLayout.GROWS_HORIZONTALLY);

        window.addComponent(new EmptySpace(), LinearLayout.GROWS_HORIZONTALLY);
        window.addComponent(panel2, LinearLayout.GROWS_HORIZONTALLY);
    }

    public static void wybierzDate() {
        window.removeAllComponents();

        Panel panel = new Panel("Krok 1");
        Component text = new Label("Wybierz dzień, który Cię interesuje");

        text.setAlignment(Component.Alignment.CENTER);
        panel.setAlignment(Component.Alignment.CENTER);

        panel.addComponent(new EmptySpace(), LinearLayout.GROWS_HORIZONTALLY);
        panel.addComponent(text, LinearLayout.GROWS_HORIZONTALLY);
        panel.addComponent(new EmptySpace(), LinearLayout.GROWS_HORIZONTALLY);

        window.addComponent(new EmptySpace(), LinearLayout.GROWS_HORIZONTALLY);
        window.addComponent(panel, LinearLayout.GROWS_HORIZONTALLY);

        Calendar calendar = Calendar.getInstance();

        Date date = calendar.getTime();
        Button data1_button = new Button(simpleDateFormat.format(date).toString(), new Action() {
            public void doAction() {
                biletData = calendar.getTime();
                wybierzKategorie();
            }
        });
        data1_button.setAlignment(Component.Alignment.CENTER);
        panel.addComponent(data1_button, LinearLayout.GROWS_HORIZONTALLY);

        calendar.add(Calendar.DAY_OF_MONTH, 1);
        date = calendar.getTime();
        Button data2_button = new Button(simpleDateFormat.format(date).toString(), new Action() {
            public void doAction() {
                biletData = calendar.getTime();
                wybierzKategorie();
            }
        });
        data2_button.setAlignment(Component.Alignment.CENTER);
        panel.addComponent(data2_button, LinearLayout.GROWS_HORIZONTALLY);

        calendar.add(Calendar.DAY_OF_MONTH, 1);
        date = calendar.getTime();
        Button data3_button = new Button(simpleDateFormat.format(date).toString(), new Action() {
            public void doAction() {
                biletData = calendar.getTime();
                wybierzKategorie();
            }
        });
        data3_button.setAlignment(Component.Alignment.CENTER);
        panel.addComponent(data3_button, LinearLayout.GROWS_HORIZONTALLY);

        calendar.add(Calendar.DAY_OF_MONTH, 1);
        date = calendar.getTime();
        Button data4_button = new Button(simpleDateFormat.format(date).toString(), new Action() {
            public void doAction() {
                biletData = calendar.getTime();
                wybierzKategorie();
            }
        });
        data4_button.setAlignment(Component.Alignment.CENTER);
        panel.addComponent(data4_button, LinearLayout.GROWS_HORIZONTALLY);

        calendar.add(Calendar.DAY_OF_MONTH, 1);
        date = calendar.getTime();
        Button data5_button = new Button(simpleDateFormat.format(date).toString(), new Action() {
            public void doAction() {
                biletData = calendar.getTime();
                wybierzKategorie();
            }
        });
        data5_button.setAlignment(Component.Alignment.CENTER);
        panel.addComponent(data5_button, LinearLayout.GROWS_HORIZONTALLY);

        calendar.add(Calendar.DAY_OF_MONTH, 1);
        date = calendar.getTime();
        Button data6_button = new Button(simpleDateFormat.format(date).toString(), new Action() {
            public void doAction() {
                biletData = calendar.getTime();
                wybierzKategorie();
            }
        });
        data6_button.setAlignment(Component.Alignment.CENTER);
        panel.addComponent(data6_button, LinearLayout.GROWS_HORIZONTALLY);

        calendar.add(Calendar.DAY_OF_MONTH, 1);
        date = calendar.getTime();
        Button data7_button = new Button(simpleDateFormat.format(date).toString(), new Action() {
            public void doAction() {
                biletData = calendar.getTime();
                wybierzKategorie();
            }
        });
        data7_button.setAlignment(Component.Alignment.CENTER);
        panel.addComponent(data7_button, LinearLayout.GROWS_HORIZONTALLY);

        Button cancel = new Button("Anuluj zakup biletu", new Action() {
            public void doAction() {
                window.close();
            }
        });

        panel.addComponent(new EmptySpace(), LinearLayout.GROWS_HORIZONTALLY);
        window.addComponent(new EmptySpace(), LinearLayout.GROWS_HORIZONTALLY);
        cancel.setAlignment(Alignment.CENTER);
        window.addComponent(cancel, LinearLayout.GROWS_HORIZONTALLY);
    }

    public static void start() {
        window.removeAllComponents();
        window.setWindowSizeOverride(new TerminalSize(100,25));
        window.setSoloWindow(true);

        Component text = new Label("Kliknij ENTER aby rozpocząć");
        text.setAlignment(Component.Alignment.CENTER);

        Button start_button = new Button("Start", new Action() {
            public void doAction() {
                wybierzDate();
            }
        });
        start_button.setAlignment(Component.Alignment.CENTER);

        TextComponent tc = new TextArea();

        window.addComponent(new EmptySpace(), LinearLayout.GROWS_HORIZONTALLY);
        window.addComponent(text, LinearLayout.GROWS_HORIZONTALLY);
        window.addComponent(new EmptySpace(), LinearLayout.GROWS_HORIZONTALLY);
        window.addComponent(start_button, LinearLayout.GROWS_HORIZONTALLY);

        guiScreen.getScreen().startScreen();
        guiScreen.showWindow(window);
        guiScreen.getScreen().stopScreen();
    }

    public static void main(String[] args) {
        start();
//        GUIScreen guiScreen = TerminalFacade.createGUIScreen();
//        guiScreen.getScreen().startScreen();

//        DialogResult result = MessageBox.showMessageBox(guiScreen, "Hello 1989!", "Ready to configure your SoundBlaster IRQs?");
//        ComboBox<String> comboBox = new ComboBox<String>();
    }
}
