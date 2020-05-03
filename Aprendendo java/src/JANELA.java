
import java.awt.Color; //pacote responsavel pelas cores do programa
import java.awt.Dimension;
import java.awt.Font;// usada para pegar as fontes de texto
import java.awt.HeadlessException;// usada para tratamento de ecessoes
import java.awt.Toolkit;// usada para pegar algumas ferramentas nativas da linguagem java ligando os varios componentes do desgn
import java.awt.event.ActionEvent;//pega por parametro a açao realizada no componente button
import java.awt.event.ActionListener;// pega os eventos da açao
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;// indica que alguma tecla foi digitada
import java.awt.event.KeyListener;// verifica se alguma tecla foi digitada
import javafx.scene.layout.Border;
import javax.swing.Icon;// necessario para exibir o icone personalizado do nosso projetto
import javax.swing.ImageIcon;// necessario para exibir o icone personalizado do nosso projetto
import javax.swing.JButton;// conponente necessario para criar os botoes 
import javax.swing.JFrame;//usada como superclasse para criarmos a janela principal
import javax.swing.JInternalFrame;
import javax.swing.JLabel;// conponente que exibe um texto e nao pode ser editado 
import javax.swing.JOptionPane;//necessario para exibirmos mensagem em uma pequena janela

/**
 * Para a Criaçao desse projeto foi necessario implementar as interfaces
 * Runnable, ActionListener Runnable tornou possivel eu usar thred
 * para fazer o programa ser executado no metodo Run(), desviando o foco da
 * thread man .ActionListener tornou possivel pegar os valores dos botoes do
 * programa quando clicados 
 * 
 *
 *
 *
 */

public class JANELA extends JFrame implements Runnable, ActionListener {

    private final int larg = 50;// define o largura dos botoes 
    private final int comp = 50; // define o comprimento dos botoes 
    private JLabel lblResultado2 = new JLabel();//instancia da label que exibe o resultado das operaçoes
    private JLabel lblResultado1 = new JLabel();//instancia da label que exibe o resultado das operaçoes
    private JButton botao9 = criarBotao();//botoes do tipo JButton recebendo configuraçoes do metodo criar botao
    private JButton botao8 = criarBotao();//botoes do tipo JButton recebendo configuraçoes do metodo criar botao
    private JButton botao7 = criarBotao();//botoes do tipo JButton recebendo configuraçoes do metodo criar botao
    private JButton botao6 = criarBotao();//botoes do tipo JButton recebendo configuraçoes do metodo criar botao
    private JButton botao5 = criarBotao();
    private JButton botao4 = criarBotao();//botoes do tipo JButton recebendo configuraçoes do metodo criar botao
    private JButton botao3 = criarBotao();
    private JButton botao2 = criarBotao();//botoes do tipo JButton recebendo configuraçoes do metodo criar botao
    private JButton botao1 = criarBotao();
    private JButton botao0 = criarBotao();
    private JButton botaoPonto = criarBotao();//botoes do tipo JButton recebendo configuraçoes do metodo criar botao
    private double numer1;//recebe o valor inicial digitado
    private double numer2;//recebe o segundo valor digitado
    private int click;// variavel de controle: para evitar que o usuario click duas vezes no operador e ocorra algun erro
    private char sinal;// operadores matematicos
    OperacoesMatematicas num = new OperacoesMatematicas();//instancia de um objeto  da nossa classe propria para calculos matematicos

    public JANELA() throws HeadlessException {// construtor  throws usado para informar ao compilador que pode ocorrer algum erro mas nao desejamos corrigir

        this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("icone/calculadora.png")));//icone da calculadora que aparece na barra de tarefas
    }

    public JButton criarBotao() {//metodo com configuraçoes genericas dos botoes 

        JButton botao = new JButton();
        botao.setFont(new Font(Font.SERIF, Font.BOLD, 24));// inserindo a fonte 
        botao.setBackground(new Color(158, 158, 162));//inserindo a cor de fundo dos botoes
        botao.setForeground(new Color(255, 255, 255));//inserindo a cor do texto
        botao.setVisible(true); // deixando os botoes visiveis

        return botao; // return um botao com todas as funçoes anteriores adicionadas
    }

    

    public void calculos() { // retorna os calculos realizados quando a iguadade é precionada
try{
        if (JANELA.this.sinal == 'o') {

            JOptionPane.showMessageDialog(null, "Digite um Operador Matematico\n" + "   +    -   /    *");
        }
        
            JANELA.this.numer2 = Double.parseDouble(JANELA.this.lblResultado2.getText());
            JANELA.this.lblResultado2.setText("");
            switch (JANELA.this.sinal) {
                case '+':
                    JANELA.this.lblResultado1.setText("" + num.soma(numer1, numer2));
                    numer1 = Double.parseDouble(JANELA.this.lblResultado1.getText());
                    JANELA.this.lblResultado2.setText("");
                    JANELA.this.sinal = 'o';
                    break;
                case '*':
                    JANELA.this.lblResultado1.setText("" + num.multiplicaco(numer1, numer2));
                    numer1 = Double.parseDouble(JANELA.this.lblResultado1.getText());
                    JANELA.this.lblResultado2.setText("");
                    JANELA.this.sinal = 'o';
                    break;
                case '-':
                    JANELA.this.lblResultado1.setText("" + num.subtracao(numer1, numer2));
                    
                    numer1 = Double.parseDouble(JANELA.this.lblResultado1.getText());
                    JANELA.this.lblResultado2.setText("");
                    JANELA.this.sinal = 'o';
                    break;
                case '/':
                    if (numer1 != 0 && numer2 !=0) {
                    JANELA.this.lblResultado1.setText("" + num.divisao(numer1, numer2));
                    numer1 = Double.parseDouble(JANELA.this.lblResultado1.getText());
                    JANELA.this.lblResultado2.setText("");
                    JANELA.this.sinal = 'o';}
                   else {
                        JOptionPane.showMessageDialog(null, "Nao é Possivel fazer divisao por zero");
                        this.lblResultado1.setText("");
                        
                    }
                    break;
            
        }}
catch(NumberFormatException ex){
        JOptionPane.showMessageDialog(null, "erro de conversao do numero"+ex);
        }
        

    }

    @Override
    public void run() { //metodo principal da thred

        lblResultado2.setBounds(30, 48, 310, 45);//inserindo a localizaçao da label
       

        lblResultado2.setOpaque(true); // deixando o label com a cor prata destacada e visivel
        lblResultado2.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 26));// fonte
        lblResultado2.setBackground(new Color(248, 248, 255));//cor de fundo 
        lblResultado2.setVisible(true);// deixando visivel na janela

        this.add(lblResultado2);// adicionando a label na janela 

        lblResultado1.setBounds(30, 3, 310, 45);//inserindo a localizaçao da label
        lblResultado1.setVisible(true);// deixando visivel na janela

        lblResultado1.setOpaque(true);// deixando o label com a cor prata destacada e visivel
        lblResultado1.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 26));// fonte
        lblResultado1.setBackground(new Color(248, 248, 255));//cor de fundo 

        this.add(lblResultado1);// adicionando a label na janela 

        this.setLayout(null);// configuraçao inicial do layout padrao
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// definindo os botoes de maximizar e minimizar

        botao9.setText(String.valueOf(9));// a String.value(9) esta converter o inteiro 9 para string e inserindo no botao 9
        botao9.setBounds(30, 100, this.comp, this.larg);// inserindo a localizaçao do botao
        botao9.addActionListener(new ActionListener() {// o metodo addActionListener recebe um instancia com o metodo ActionPerformed que é execultado quando clica no botao
            @Override
            public void actionPerformed(ActionEvent e) { // sobreescrevendo o metodo padrao da interface ActionListener responsavel pela açao
                // aqui acontece a açao do botao
                lblResultado2.setText(lblResultado2.getText() + "" + botao9.getText());//label2 recebe a concatenaçao dele com o valor do botão 
            }
        });

        this.add(botao9); // adicionando o botao na janela

        botao8.setBounds(90, 100, this.comp, this.larg);// inserindo a localizaçao do botao
        botao8.addActionListener((ActionEvent e) -> {

            lblResultado2.setText(lblResultado2.getText() + "" + botao8.getText());// concatenando o valor presente no botao

        });
        botao8.setText(String.valueOf(8));

        this.add(botao8);// adicionando o botao na janela

        botao7.setText("7");
        botao7.setBounds(150, 100, this.comp, this.larg);
        botao7.addActionListener((ActionEvent e) -> {
            lblResultado2.setText(lblResultado2.getText() + "" + botao7.getText());// concatenando o valor presente no botao

        });

        this.add(botao7);

        botao6.setText(String.valueOf("6"));
        botao6.setBounds(30, 155, this.comp, this.larg);
        botao6.addActionListener((ActionEvent e) -> {
            lblResultado2.setText(lblResultado2.getText() + "" + botao6.getText());// concatenando o valor presente no botao

        });

        this.add(botao6);

        botao5.setText(String.valueOf("5"));
        botao5.setBounds(90, 155, this.comp, this.larg);

        botao5.addActionListener((ActionEvent e) -> {
            lblResultado2.setText(lblResultado2.getText() + "" + botao5.getText());// concatenando o valor presente no botao

        });
        this.add(botao5);

        botao4.setText(String.valueOf("4"));
        botao4.setBounds(150, 155, this.comp, this.larg);
        botao4.addActionListener((ActionEvent e) -> {
            lblResultado2.setText(lblResultado2.getText() + "" + botao4.getText());// concatenando o valor presente no botao

        });
        this.add(botao4);

        botao3.setText(String.valueOf("3"));
        botao3.setBounds(30, 210, this.comp, this.larg);
        botao3.addActionListener((ActionEvent e) -> {
            lblResultado2.setText(lblResultado2.getText() + "" + botao3.getText());// concatenando o valor presente no botao

        });
        this.add(botao3);

        botao2.setText(String.valueOf("2"));
        botao2.setBounds(90, 210, this.comp, this.larg);
        botao2.addActionListener((ActionEvent e) -> {
            lblResultado2.setText(lblResultado2.getText() + "" + botao2.getText());// concatenando o valor presente no botao

        });
        this.add(botao2);

        botao1.setText(String.valueOf("1"));
        botao1.setBounds(150, 210, this.comp, this.larg);
        botao1.addActionListener((ActionEvent e) -> {
            lblResultado2.setText(lblResultado2.getText() + "" + botao1.getText());// concatenando o valor presente no botao

        });
        this.add(botao1);

        botao0.setText(String.valueOf("0"));
        botao0.setBounds(30, 265, this.comp + 60, this.larg);
        botao0.addActionListener((ActionEvent e) -> {
            lblResultado2.setText(lblResultado2.getText() + "" + botao0.getText());// concatenando o valor presente no botao

        });
        this.add(botao0);

        botaoPonto.setText(String.valueOf("."));
        botaoPonto.setBounds(150, 265, this.comp, this.larg);
        botaoPonto.addActionListener((ActionEvent e) -> {
            if ("".equals(lblResultado2.getText())) {
                lblResultado2.setText("");
            } else {
                lblResultado2.setText(lblResultado2.getText() + "" + botaoPonto.getText());// concatenando o valor presente no botao

            }
        });
        this.add(botaoPonto);
        JButton botaoCe = criarBotao();

        botaoCe.setText(String.valueOf("ce"));//reseta a calcularadora
        botaoCe.setBounds(210, 100, this.comp + 20, this.larg);
        botaoCe.addActionListener((ActionEvent e) -> {
            lblResultado1.setText("");
            lblResultado2.setText("");
            this.numer1 = 0;
            this.numer2 = 0;
            this.click = 0;
        });
        this.add(botaoCe);
        JButton botaoC = criarBotao();

        botaoC.setText(String.valueOf("c"));//apaga o utimo caracter
        botaoC.setBounds(210, 155, this.comp + 20, this.larg);
        botaoC.addActionListener((ActionEvent e) -> {

            if (lblResultado2.getText().length() > 0) {
                lblResultado2.setText(lblResultado2.getText().substring(0, lblResultado2.getText().length() - 1));
    // transforma a String em uma cadeia de caracter e elimina o ultimo
            }

        });
        this.add(botaoC);
        JButton botaoIgual = criarBotao();

        botaoIgual.setText(String.valueOf("="));
        botaoIgual.setBounds(210, 210, this.comp + 20, this.larg + 55);
        botaoIgual.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculos(); // chamada ao metodo que realiza as operaçoes

            }
        });
        this.add(botaoIgual);
        JButton botaoDiv = criarBotao();

        botaoDiv.setText(String.valueOf("/"));//faz a conersao do caracter / para string
        botaoDiv.setBounds(290, 100, this.comp, this.larg);
        botaoDiv.addActionListener((ActionEvent e) -> {
            ++click;

            if (click == 1) {
                try{
                this.numer1 = Double.parseDouble(lblResultado2.getText());}
                catch(NumberFormatException ex){
                System.err.println("divisao por zero dectatada" + ex);
                }
                lblResultado1.setText("" + this.numer1 + " " + "/");
                lblResultado2.setText("");
            }

            if (click >= 2) {
               if(numer2==0){
                this.numer1=0;
                this.numer1 = Double.parseDouble(lblResultado2.getText());
                lblResultado2.setText("");}
                if (lblResultado1.getText().length() > 0) { // entra se o tamanho do texto for maior que 0
                    lblResultado1.setText(lblResultado1.getText().substring(0, lblResultado1.getText().length() - 1));//label recebe a string menos o ultimo caracter digitado
                }
            }
            this.sinal = botaoDiv.getText().charAt(0);// conversao da string de divisao para caracter
            lblResultado1.setText("" + this.numer1 + " " + this.sinal);// concatenaçao do primeiro valor digitado com o sinal

        });
        this.add(botaoDiv);//adicionando botao divisao na janela
        JButton botaoMult = criarBotao();

        botaoMult.setText(String.valueOf("*"));
        botaoMult.setBounds(290, 155, this.comp, this.larg);
        botaoMult.addActionListener(new ActionListener() { //adicionando uma classe interna para comunicaçao externa do metodo ActionPerfomed responsavel pela açao do botao
            @Override
            public void actionPerformed(ActionEvent e) {//sobreescrevendo o metodo da interface ActionListener responsavel pela açao do botao
                ++click;
                if (click == 1) {
                    JANELA.this.numer1 = Double.parseDouble(lblResultado2.getText());
                    lblResultado1.setText("" + JANELA.this.numer1 + " " + "*");//concatena o valor recebido da label 2 e adiciona a label 1
                    lblResultado2.setText("");
                    JANELA.this.sinal = botaoMult.getText().charAt(0);//faz a conversao da string do botao e adciona a essa variavel
                    lblResultado1.setText("" + JANELA.this.numer1 + " " + JANELA.this.sinal);
                }
                if (click >= 2) {
                    if (lblResultado1.getText().length() > 0) {
                        lblResultado1.setText(lblResultado1.getText().substring(0, lblResultado1.getText().length() - 1));
                    }
                    JANELA.this.sinal = botaoMult.getText().charAt(0);
                    lblResultado1.setText("" + JANELA.this.numer1 + " " + JANELA.this.sinal);
                }
            }
        });
        this.add(botaoMult);
        JButton botaoSub = criarBotao();

        botaoSub.setText(String.valueOf("-"));
        botaoSub.setBounds(290, 210, this.comp, this.larg);
        botaoSub.addActionListener((ActionEvent e) -> {
           ++click;
          
           
            if (click == 1 ) {
               
                this.numer1 = Double.parseDouble(lblResultado2.getText());
                lblResultado1.setText("" + this.numer1 + " " + "-");
                lblResultado2.setText("");
            }
                
            

            if (click >= 2 ) {
                
                if (lblResultado1.getText().length() > 0 && numer1!=0) {
                    lblResultado1.setText(lblResultado1.getText().substring(0, lblResultado1.getText().length() - 1));
                   
                }
            
            }
             this.sinal = botaoSub.getText().charAt(0);
            lblResultado1.setText("" + this.numer1 + " " + this.sinal);
            
        });
        this.add(botaoSub);
        JButton botaoSoma = criarBotao();

        botaoSoma.setText(String.valueOf("+"));
        botaoSoma.setBounds(290, 265, this.comp, this.larg);
        botaoSoma.addActionListener((ActionEvent e) -> {
            ++click;
            if (click == 1) {
                this.numer1 = Double.parseDouble(lblResultado2.getText());
                lblResultado1.setText("" + this.numer1 + " " + "+");
                lblResultado2.setText("");
            }

            if (click >= 2) {
                if (lblResultado1.getText().length() > 0) {
                    lblResultado1.setText(lblResultado1.getText().substring(0, lblResultado1.getText().length() - 1));
                }
            }
            this.sinal = botaoSoma.getText().charAt(0);
            lblResultado1.setText("" + this.numer1 + " " + this.sinal);

        });
        this.add(botaoSoma);

        this.getContentPane().setBackground(new Color(255, 255, 255)); // adicionando a cor de fundo da janela
        this.setSize(380, 400); //tamanho da janela
        this.setUndecorated(false);//melhorando as bordas da janela
        this.setLocationRelativeTo(this);//localiçao da janela centralizada
        this.setTitle("Calculadora WED");//titulo da janela

        this.setVisible(true);
        this.setResizable(false);// nao permitir o usuario maximizar a janela

    }

    @Override
    public void actionPerformed(ActionEvent ae) { // metodo obrigatorio da interface ActionListener mas nao esta sendo utilizado
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    

}
