package rotateString;

public class RotateString {
	
	public static void main(String[] args) {
		int count = -1;
		String str = "abcdefg";
		
		for(int i = str.length(); i > 0; i--) {
			count++;
			System.out.println("rigth "+count+" -> " + rotate(str,count));
		}
		
		//System.out.println("----------------");
		for(int i = (str.length() - 1); i > 0; i--) {
			count--;
			System.out.println("left  "+count+" -> " + rotate(str,count));
		}	
	}
	
	public static String rotate(String str,int pos){
        if(str==null || str.isEmpty() || pos<0 || pos>=str.length()){
            return null;
        }
        str = reverse(str,0,pos-1);
        str = reverse(str,pos,str.length()-1);
        str = reverse(str,0,str.length()-1);
        return str;
    }

    private static String reverse(String str,int start,int end){
        char[] chars = str.toCharArray();
        while(start<=end){
            char tmp = chars[start];
            chars[start]=chars[end];
            chars[end]=tmp;
            start++;
            end--;
        }
        return new String(chars);
    }
}