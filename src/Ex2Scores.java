
public interface Ex2Scores {
	/*@ pure helper @*/int getMAXSCORES();


	//@ instance invariant numRecords()>=0 && numRecords()<=getMAXSCORES();
	//@ instance invariant numRecords()>0 ==> (worstScore() == (\min int i; 0<=i && i<numRecords(); getScore(i)));
	//@ instance invariant numRecords()>0 ==> (bestScore() == (\max int i; 0<=i && i<numRecords(); getScore(i)));
	// ensures(\forall int i,j;i<=0 && i<j && j<numRecords();getScore(i) <= getScore(j));


	/*@
		  @ requires umScore > 0 && umNome != null && umNome.length() > 0;
		  @ requires numRecords() == getMAXSCORES() && umScore <= worstScore();
		  @ ensures \result == false;
	    @ ensures (\forall int i,j;i<=0 && i<j && j<numRecords();getScore(i) <= getScore(j));
		  @ also
		  @ requires umScore > 0 && umNome != null && umNome.length() > 0;
		  @ requires numRecords() < getMAXSCORES();
		  @ ensures numRecords() == \old(numRecords()) + 1;
		  @ ensures (\exists int i; 0<=i && i<numRecords(); getScore(i)==umScore);
	    @ ensures \result == true;
		  @ also
		  @ requires umScore > 0 && umNome != null && umNome.length() > 0;
		  @ requires numRecords() == getMAXSCORES() && umScore > worstScore();
		  @ ensures numRecords() == \old(numRecords());
	    @ ensures (\exists int i; 0<=i && i<numRecords(); getScore(i)==umScore);
	    @ ensures !(\exists int i; 0<=i && i<numRecords(); getScore(i)==\old(worstScore()));
		  @ ensures \result == true;
		  @*/
	boolean add(String umNome,int umScore);

	/*@ pure helper @*/ 
	int numRecords();

	//@ requires numRecords() > 0;
	//@ requires i>=0 && i<numRecords();
	/*@ pure helper @*/ 
	int getScore(int i);

	//@ requires numRecords() > 0;
	/*@ pure helper @*/ 
	int worstScore();

	//@ requires numRecords() > 0;
	/*@ pure helper @*/ 
	int bestScore();
}
