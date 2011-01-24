package info.relson.lib.console.util;


/**
* Classe Console com operacoes no Modo ANSI
* @author bach
* @see http://www.vivaolinux.com.br/~bach
* @version 1.0.001   
*/
public class JConsoleUtil {
  
   /**
    * Imprime uma mensagens coloridas
    * @param mensagem Mensagem a ser mostrada na saida padrao
    * @param listArgs Lista de argumentos como Cor do Fundo...
    */  
   public static void printc(String mensagem, String... listArgs)
   {
         String cmd = "";        
        
         // Separando os comandos com ";"
         for(String args:listArgs)
         {
            cmd = cmd + args + ";";            
         }
        
         // Retirando o ultimo ";"
         cmd = cmd.substring(0,cmd.length() -1);
        
         // Adicionando o m no final da frase e finalizando o comando
         cmd = cmd + "m";
                  
         System.out.printf("%s%s%s",
               "\033["+cmd,
               mensagem,
               "\033[0m"); // O Comando \033[0m da um "reset" ao console
                       // e volta tudo como anteriormente
        
   }
  
   /**
    * Leva o cursor para a linha e coluna informado
    * @param linha
    * @param coluna
    */
   public static void posicionar(int linha, int coluna)
   {
      System.out.printf("\033[%d;%dH", linha, coluna);
   }
  
   /**
    * Limpa o Console e posiciona o final do Console
    *
    */
   public static void limpar()
   {
      System.out.printf("\033[2J");
   }
  
   /**
    * Metodo main para testar todas as funcoes
    * @param args
    */
   public static void main(String[] args) {

	 
      JConsoleUtil.limpar();
      JConsoleUtil.posicionar(10, 37);
      JConsoleUtil.printc("Alerta!\n\n", "44", "31", "1", "5");
   }

} 