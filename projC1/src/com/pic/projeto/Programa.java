class Programa
{
    public static void main (String[] args)
    {
        Pilha<String>        pilha=null;
      //Pilha<Boolean>       pilha=null;
      //Pilha<Character>     pilha=null;
      //Pilha<Pilha<String>> pilha=null;
        char  opcao;
        do
        {
            try
            {
                System.out.println ();
                System.out.println ("(a) Criar nova pilha");
                System.out.println ("(b) Guardar");
                System.out.println ("(c) Jogar fora");
                System.out.println ("(d) Recuperar");
                System.out.println ("(e) Cheia?");
                System.out.println ("(f) Vazia?");
                System.out.println ("(g) Quantos?");
                System.out.println ("(h) Sair");
                System.out.print   ("Sua opcao? ");
                opcao = Character.toLowerCase(Teclado.getUmChar());
            }
            catch (Exception erro)
            {
                opcao='z';
            }

            if (opcao>='b'&&opcao<='g'&&pilha==null)
            {
                System.err.println ("Nao ha pilha");
                continue;
            }

            switch (opcao)
            {
                case 'a':
                try
                {
                    System.out.print ("Qual o tamanho? ");
                    int tamanho = Teclado.getUmInt();
                    pilha = new Pilha<String>        (tamanho);
                  //pilha = new Pilha<Boolean>       (tamanho);
                  //pilha = new Pilha<Character>     (tamanho);
                  //pilha = new Pilha<Pilha<String>) (tamanho);
                    System.out.println ("Pilha criada com sucesso!");
                }
                catch (Exception erro)
                {
                    System.err.println ("Tamanho invalido!");	
                }
                finally
                {
                    break;
                }

                case 'b':
                System.out.print ("O que quer guardar? ");
                String str = Teclado.getUmString();
                try
                {
                    pilha.guarde (str);
                    System.out.println ("Guardado com sucesso!");
                }
                catch (Exception erro)
                {
                    System.err.println ("Nao cabe!");
                }
                finally
                {
                    break;
                }

                case 'c':
                try
                {
                    pilha.jogueForaValor();
                    System.out.println ("Jogado fora com sucesso!");
                }
                catch (Exception erro)
                {
                    System.err.println ("Pilha vazia!");
                }
                finally
                {
                    break;
                }

                case 'd':
                try
                {
                    System.out.println ("Valor: "+pilha.getValor());
                }
                catch (Exception erro)
                {
                    System.err.println ("Pilha vazia!");
                }
                finally
                {
                    break;
                }

                case 'e':
                if (pilha.isCheia())
                    System.out.println ("Sim, a pilha esta cheia!");
                else
                    System.out.println ("Nao, a pilha nao esta cheia!");
                break;

                case 'f':
                if (pilha.isVazia())
                    System.out.println ("Sim, a pilha esta vazia!");
                else
                    System.out.println ("Nao, a pilha nao esta vazia!");
                break;

                case 'g':
                System.out.printf ("Ha %d elemento(s) na pilha!\n",
                                   pilha.getQuantos());
                break;

                case 'h':
                break;

                default:
                System.err.println ("Opcao invalida! Tente novamente...\n");
            }
        }
        while (opcao!='h');
    }
}