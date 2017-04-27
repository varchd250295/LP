import java.io.*;
import java.lang.*;

class TokenCount
{

int isKeyword(String token)
{
    const char keywords[32][20]={"auto","break","case","char",
                                "const","continue","default","do","double",
                                "else","enum","extern","float",
                                "for","goto","if","int","long",
                                "register","return","short","signed",
                                "sizeof","static","struct","switch",
                                "typedef","union","unsigned",
                                "void","volatile","while"};
    for(int i=0;i<32;i++)
    {
        if(token.equals(keyword[i]))
            return 1;
    }
    return 0;
}

int isIntLiteral(String token)
{
    for(int i=0;token[i];i++)
    {
        if(!Character.isDigit(token))
            return 0;
    }
    return 1;
}

int isFloatLiteral(String token)
{
    if(Character.isDigit(token.charAt(0)))
    {
        for(int i=1;i<token.length();i++)
        {
            if(!Character.isdigit(token.charAt(i)) && (token.charAt(i)!='.' || token.charAt(i)!='E'))
                return 0;
        }
        return 1;
    }
    return 0;
}

int isCharLiteral(String token)
{
	if(token.charAt[0]=='\'' && token.length()==3 && token.charAt[2]=='\'')
        return 1;
    else
        return 0;
}

int isLiteral(String token)
{
    if(isCharLiteral(token)||isIntLiteral(token)||isFloatLiteral(token))
        return 1;
    else
        return 0;
}

int isIdentifier(String token)
{
    if(Character.isLetter(token[0]) || token.charAt(0)=='_')
    {
        for(int i=1;i<token.length();i++)
        {
            if(token.CharAt(i)=='_' && token.CharAt(i-1)=='_' || token.matches("^.*[^a-zA-Z0-9 ].*$") )
                return 0;

        }
        return 1;
    }
    return 0;
}


int isOperator(String token)
{
    const char operators[41][10] = {".","->","++","--","!","~","(type)","*","&",
                                 "sizeof","*","/","%","+","-","<<",">>","<",
                                 "<=",">",">=","==","!=","&","^","|","&&","||",
                                 "?:","=","+=","-=","*=","/=","%=","&=","^=",
                                 "|=","<<=",">>=",","};

    for(int i=0;i<41;i++)
    {
        if(token.equals(operators[i]))
            return 1;
    }
    return 0;
}



public static void main(String args[])throws IOException
{
  	int count=0,sc=1,found=0,i=0;


	FileReader fr = new FileReader("IP_C.java");
	BufferedReader br = new BufferedReader(new FileReader("IP_C.java"));
	FileWriter fw = new FileWriter("count.txt");

    String token;
    const char delimiters[]=" .,;!=\n\t";

	StringTokenizer st = new StringTokenizer("my name is khan"," ");

    while( fgets(string,sizeof string, fp)!=NULL )
    {
        token = strtok(string,delimiters);

        while(token!=NULL)
        {

			for(int i=0;i<count;i++)
			{
				if(strcmp(a[i],token)==0)
					found=1;
			}

			if(found==1)
			{
				found=0;
				continue;
			}
			else
			{
				count++;
				strncpy(a[count], token, sizeof token-1);

			}



            if(isKeyword(token))
            	if(strcmp(token,"byte")==0 || strcmp(token,"char")==0)
            		printf(" %d \t %s \t Keyword \t - \t 1 byte \n",count,token);
            	else
            	if(strcmp(token,"short")==0)
            		printf(" %d \t %s \t Keyword \t - \t 2 bytes \n",count,token);
            	else
            	if(strcmp(token,"int")==0)
            		printf(" %d \t %s \t Keyword \t - \t 4 bytes \n",count,token);
            	else
            	if(strcmp(token,"long")==0 || strcmp(token,"float")==0)
            		printf(" %d \t %s \t Keyword \t - \t 8 bytes \n",count,token);
            	else
            	if(strcmp(token,"double")==0)
            		printf(" %d \t %s \t Keyword \t - \t 16 bytes \n",count,token);

                else   	printf(" %d \t %s \t Keyword \t - \t - \n",count,token);
            else if(isOperator(token))
                 printf(" %d \t %s \t Operator \t - \t - \n",count,token);
            else if(isIdentifier(token))
                 printf(" %d \t %s \t Identifier \t %s \t - \n",count,token,scope[sc]);
            else if(isLiteral(token))
                printf(" %d \t %s \t Literal \t - \t - \n",count,token);
            else
                 printf(" %d \t %s \t Symbol \t - \t - \n",count,token);

            token = strtok(NULL,delimiters);
        }
        fgets(string,sizeof string, fp);
    }

    fclose(fp);
    return 0;
}