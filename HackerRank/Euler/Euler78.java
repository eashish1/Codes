import java.io.*;
import java.util.*;
class Euler78
{
	static long[] p=new long[80005];
	static int mod=1000000007;
	static void init()
	{
		int[] k=new int[80005];
		k[0]=1;
		k[1]=-1;
		for(int i=2;i<k.length;i++)
		{
			if (i%2==0)
				k[i]=k[i-2]+1;
			else k[i]=-k[i-1];
		}
		// System.out.println(Arrays.toString(k));
		long[] g=new long[80005];
		for(int i=0;i<g.length;i++)
		{
			g[i]=((k[i]%mod*(3*k[i]-1)%mod)/2)%mod;
		}
		// System.out.println(Arrays.toString(g));
		// int[] p=new int[10];

		p[0]=1;p[1]=1;
		for(int i=2;i<p.length;i++)
		{
			int j=0;
			while(i>=g[j])
			{				
				// System.out.println((int)Math.pow(-1,k[j]-1)+" j is "+j+" k[j] is "+k[j]+" k[j]-1 is "+(k[j]-1));
				// if(i-g[j]>=0)
					p[i] = (p[i] + ((p[i-(int)g[j]])*((int)Math.pow(-1,k[j]-1)))%mod)%mod;
					p[i] = p[i]%mod;
					// System.out.println("at i "+i+" p[i] "+p[i]+" g[j] "+g[j]);
					++j;
			}
			if(p[i]<0)
				p[i]+=mod;
		}
		//System.out.println(Arrays.toString(p));
	}	

	public static void main(String args[]) throws Exception
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(br.readLine());
		init();
		while(t-->0)
		{
			int val=Integer.parseInt(br.readLine());
			System.out.println(p[val]);
		}		
	}
}
