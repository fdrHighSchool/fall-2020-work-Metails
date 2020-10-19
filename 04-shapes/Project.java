
//By: Mehmet Soydan, Jian Hua Deng
class Project{
  public static void main(String[] args){
    taskA();
    System.out.println("\n");
    taskB();
    System.out.println("\n");
    taskC();
    System.out.println("\n");
    taskD();
    System.out.println("\n");
    taskE();
    System.out.println("\n");
    for(int a = 0; a <= 4; a++){
      taskF(a);
    }//end a for loop

}//end method

  public static void taskA(){
    int size = 25;
    int position = 0;
    for(int i = 0; i<size; i++){
      if(position % 5 ==0){
      System.out.println();
    }
    System.out.print("*");
    position++;
    }
  }
  public static void taskB(){
    int size = 8;
    int position = 4;
    for(int i = 0; i<size; i++){
      if(position % 4 ==0){
      System.out.println();
    }
    System.out.print("*");
    position++;
  }
  }
  public static void taskC(){
    for(int row = 0; row < 4; row++){
      for(int col = 0;col <= row; col++){
        System.out.print("*");
      }
      System.out.println();
    }//end for row
  }//end task c method

  public static void taskD(){
    int total = 18;
    int count = 0;
    int num = 0;
    for(int i = 0;i < total;i++){
      if(count % 6 == 0){
        System.out.println(" ");
        num++;
      }//end if statement
      count++;
      System.out.print(" " + num);
    }//end loop
  }//end taskD method


  public static void taskE(){
      for(int row = 1;row<=5;row++){
        System.out.println();
        for(int space = 5 - row;space > 0; space--){
          System.out.print(" ");
        }//end for blanks loop
        for(int num = row; num>0;num--)
        System.out.print(row);
      }//end for row loop

    }//end task E method

    public static void taskF(int wishes){
   for(int row = 0;row < wishes;row++){
     System.out.println();
     for(int col = 0; col < wishes; col++){
       System.out.print(" *");
     }//end for col
     System.out.println();
     }//end for row


 }//end taskF method
}//end class
