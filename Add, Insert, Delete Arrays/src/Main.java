public class Main {

    static int[] addArray(int[] array,int addition){
        int arrayLength=array.length;
        int[] newArray=new int[arrayLength+1];
        for(int i=0; i<arrayLength; i++){       //copy values to newArray
            newArray[i]=array[i];
        }
        newArray[arrayLength]=addition;     //add addition to end of newArray
        return newArray;
    }

    static int[] delArray(int[] array){
        int arrayLength=array.length;
        int newArrayLength=arrayLength-1;
        int[] newArray=new int[newArrayLength];
        for(int i=0; i<newArrayLength; i++){        //copy values to newArray excluding final value
            newArray[i]=array[i];
        }
        return newArray;
    }

    static int[] insertArray(int[] array,int addition,int position){
        int arrayLength=array.length;
        int[] newArray=new int[arrayLength+1];
        for(int i=0;i<position;i++){        //copy values prior to position to newArray
            newArray[i]=array[i];
        }
        newArray[position]=addition;        //insert addition to position
        for(int i=position+1;i<arrayLength+1;i++){      //copy values following position to newArray
            newArray[i]=array[i-1];
        }
        return newArray;
    }


    public static void main(String[] args) {
        int[] arr1=new int[4];
        int arr1Length=arr1.length;
        for(int i=0;i<arr1Length;i++){
            arr1[i]=i;
        }

        System.out.println("addition method");
        for(int i=0;i<arr1Length+1;i++){
            System.out.print(addArray(arr1,7)[i]);
        }

        System.out.println("\ndel method");
        for(int i=0;i<arr1Length-1;i++){
            System.out.print(delArray(arr1)[i]);
        }

        System.out.println("\ninsert method");
        for(int i=0;i<arr1Length+1;i++){
            System.out.print(insertArray(arr1,9,2)[i]);
        }

    }
}
