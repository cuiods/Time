package units;

public abstract class Soldier extends Unit{
	/*
	 �����ڼ̳�soldier�������½����캯��
	 �ҹ��캯����������������ݣ�
	1. ���캯������Ҫ��һ������ΪDataBase data��Ȼ�������ֵ����Ĳ���DB����������
	2.��ʵ����������Database�����Ӧֵ��ʼ��
	3. ������������Ժ���밴����Ӫ���ӵ���Ӧ��arraylist�з���
	
	 */
	
	
	/*
	 ��λ��ΪSwordMan(����)��GUNNER(��ǹ��)��CANNON(����)����;ÿ����Ӧ�Ĳ���ֵ���Ѿ���database����д�á�
	 */
	
	//�ҵ�����swordman��С�ĵ��˵�index
		public int detect() {

			//to record the temporary minimum distance and its index
			int temp=0;
			//��ʼֵΪ�����б��е�һ�����˵ľ���
			int minidistance= caldistance(this.x,db.enemyList.get(0).getX(),this.y,db.enemyList.get(0).getY());
			for(int i=0;i<db.enemyList.size();i++){
				Unit enemy=db.enemyList.get(i);
				int distance= caldistance(this.x,enemy.getX(),this.y,enemy.getY());
				//�ж��Ƿ��ǵ�ǰ��С����
				if(distance<minidistance){
						minidistance=distance;
						temp=i;
				}
			}
			return temp;
			
		}
	
}