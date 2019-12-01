package com.eduardogroders;


import java.util.*;
import java.text.*;



public class Main {

    static Scanner entrada = new Scanner(System.in);

    static final int MAX_ALUNOS = 10;
    static final int MAX_DISCIPLINA = 5;
    static final int MAX_MATRICULA = 30;

    static Aluno[] alunos = new Aluno[MAX_ALUNOS];
    static Disciplina[] disciplinas = new Disciplina[MAX_DISCIPLINA];
    static Matricula[] matriculas = new Matricula[MAX_MATRICULA];


    static void cadastrarDisciplina() {

        int contadorDisciplina = 0;

        do {
            System.out.println("Escolha: ");
            System.out.println("1 para apenas disciplina");
            System.out.println("2 para disciplina prática");
            int opcao = entrada.nextInt();

            switch (opcao) {
                case 1:
                    disciplinas[contadorDisciplina] = new Disciplina();
                    disciplinas[contadorDisciplina].setCodigoDisciplina(contadorDisciplina);

                    System.out.println("Digite o nome da disciplina:");
                    disciplinas[contadorDisciplina].setNome(entrada.next());

                    System.out.println("Digite a carga horaria geral:");
                    disciplinas[contadorDisciplina].setCargaHorariaGeral(entrada.nextInt());
                    break;

                case 2:
                    disciplinas[contadorDisciplina] = new DisciplinaPratica();
                    disciplinas[contadorDisciplina].setCodigoDisciplina(contadorDisciplina);

                    System.out.println("Digite o nome da disciplina:");
                    disciplinas[contadorDisciplina].setNome(entrada.next());

                    System.out.println("Digite a carga horaria geral:");
                    disciplinas[contadorDisciplina].setCargaHorariaGeral(entrada.nextInt());

                    System.out.println("Digite a carga horaria pratica:");
                    ((DisciplinaPratica) disciplinas[contadorDisciplina]).setCargaHorariaPratica(entrada.nextInt());
                    break;

            }

            contadorDisciplina++;
        } while (contadorDisciplina < MAX_DISCIPLINA);
        menu();

    }

    static Calendar dataNascimento(String dataNascimento) {

        DateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");
        Date dataNascFormatoCalendar = null;

        try {
            dataNascFormatoCalendar = formatoData.parse(dataNascimento);

            Calendar dateOfBirth = new GregorianCalendar();
            dateOfBirth.setTime(dataNascFormatoCalendar);

            return dateOfBirth;
        } catch (Exception e) {
        }
        return null;
    }

    static void cadastrarAluno() {
        int contadorAluno = 0;
        do {
            alunos[contadorAluno] = new Aluno();

            alunos[contadorAluno].setIdAluno(contadorAluno);

            System.out.println("Digite o nome:");
            alunos[contadorAluno].setNome(entrada.next());

            System.out.println("Digite o sobrenome:");
            alunos[contadorAluno].setSobrenome(entrada.next());

            System.out.println("Digite o sexo: [M ou F]");
            alunos[contadorAluno].setSexo(entrada.next().charAt(0));

            System.out.println("Digite a data de nascimento [dd/MM/yyyy]:");
            Calendar data = dataNascimento(entrada.next());
            alunos[contadorAluno].setDataNascimento(data);

            contadorAluno++;


        } while (contadorAluno < MAX_ALUNOS);

        menu();

    }

    static void matriculaAluno() {
        int contadorMatricula = 0;

        do {
            matriculas[contadorMatricula] = new Matricula();

            System.out.println("Digite o id do aluno:");
            int idAluno = entrada.nextInt();

            System.out.println("Digite o codigo da disciplina:");
            int codigoDisciplina = entrada.nextInt();


            System.out.println("Digite o ano letivo:");
            matriculas[contadorMatricula].setAnoLetivo(entrada.nextShort());

            System.out.println("Digite a serie:");
            matriculas[contadorMatricula].setSerie(entrada.nextByte());

            contadorMatricula++;

        } while (contadorMatricula < MAX_MATRICULA);

        menu();
    } // Fim do método matriculaAluno

    static void lançarNota() {
        int contadoLançarNota = 0;
        matriculas[contadoLançarNota] = new Matricula();

        System.out.println("Digite o id do aluno:");
        int idAluno = entrada.nextInt();

        System.out.println("Digite o codigo da disciplina:");
        int codigoDisciplina = entrada.nextInt();

        System.out.println("Digite o ano:");
        int ano = entrada.nextInt();

        float notaPrimero = 0;
        float notaSegundo = 0;
        float notaTerceiro = 0;
        float notaQuarto = 0;

        String nota1 = "1, ";
        String nota2 = "2, ";
        String nota3 = "3, ";
        String nota4 = "4";

        int bimestreDisciplina = 0;
        do {
            System.out.println("Digite o bimestre da disciplina [" + nota1 + nota2 + nota3 + nota4 + "]: \nDigite 0 para voltar ao menu");
            bimestreDisciplina = entrada.nextInt();

            switch (bimestreDisciplina) {
                case 0:
                    break;
                case 1:
                    System.out.println("Digite a nota do primeiro bimestre: de 0 a 10");
                    notaPrimero = entrada.nextFloat();
                    matriculas[contadoLançarNota].setNotaPrimeiroBimestre(notaPrimero);
                    nota1 = "";
                    break;
                case 2:
                    System.out.println("Digite a nota do segundo bimestre: de 0 a 10");
                    notaSegundo = entrada.nextFloat();
                    matriculas[contadoLançarNota].setNotaSegundoBimestre(notaSegundo);
                    nota2 = "";
                    break;
                case 3:
                    System.out.println("Digite a nota do terceiro bimestre: de 0 a 10");
                    notaTerceiro = entrada.nextFloat();
                    matriculas[contadoLançarNota].setNotaTerceiroBimestre(notaTerceiro);
                    nota3 = "";
                    break;
                case 4:
                    System.out.println("Digite a nota do quarto bimestre: de 0 a 10");
                    notaQuarto = entrada.nextFloat();
                    matriculas[contadoLançarNota].setNotaQuartoBimestre(notaQuarto);
                    nota4 = "";
                    break;
                default:
                    System.out.println("Digite um bimestre válido:");
                    break;
            }
        } while (bimestreDisciplina != 0);

        contadoLançarNota++;
        menu();

    }


    static void mostraBoletim() {

        System.out.println("Digite o id do aluno:");
        int idAluno = entrada.nextInt();

        System.out.println("Digite o ano:");
        int ano = entrada.nextInt();


        System.out.print("\nDisciplina\t\t");
        System.out.print("CH\t\t");
        System.out.print("CH Pratica\t\t");
        System.out.print("1° Bim.\t\t");
        System.out.print("2° Bim.\t\t");
        System.out.print("3° Bim.\t\t");
        System.out.print("4° Bim.\t\t");
        System.out.print("Média\t\t");
        System.out.print("Situação\n");



        menu();

    }


    static void menu() {

        int opcao;

        System.out.println("----------------Secretaria Escolar-----------------");
        System.out.println("[ 1 - \tCadastrar Disciplina                       ]");
        System.out.println("[ 2 - \tCadastrar Aluno                            ]");
        System.out.println("[ 3 - \tMatricular Aluno                           ]");
        System.out.println("[ 4 - \tLançar Nota                                ]");
        System.out.println("[ 5 - \tMostrar Boletim                            ]");
        System.out.println("[ 6 - \tFechar aplicação                           ]");
        System.out.println("--------------------------------------------------");
        System.out.println("Digite uma opção:  ");
        opcao = entrada.nextInt();

        switch (opcao) {


            case 1:
                cadastrarDisciplina();
                break;
            case 2:
                cadastrarAluno();
                break;
            case 3:
                matriculaAluno();
                break;
            case 4:
                lançarNota();
                break;
            case 5:
                mostraBoletim();
                break;
            case 6:
                break;

            default:
                menu();
                break;

        } // Fim do switch
    }


    public static void main(String[] args) {
        menu();
    } // Fim do método main


} // Fim da classe main

