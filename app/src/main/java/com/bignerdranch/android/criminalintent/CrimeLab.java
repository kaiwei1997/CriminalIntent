package com.bignerdranch.android.criminalintent;

import android.content.Context;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;


public class CrimeLab {
    private static CrimeLab sCrimeLab;

    private Map<UUID,Crime> mCrimes;

    public static CrimeLab get(Context context){
        if(sCrimeLab == null){
            sCrimeLab = new CrimeLab(context);
        }
        return sCrimeLab;
    }

    private CrimeLab(Context context){
        mCrimes = new LinkedHashMap<>();
        /**for(int i =0; i <100; i++){
            Crime crime = new Crime();
            crime.setTitle("Crime #" + i);
            crime.setSolved(i % 2 == 0);
            crime.setRequiresPolice(i % 2 == 0);
            mCrimes.put(crime.getID(),crime);
        }**/
    }

    public void addCrime(Crime c){
        mCrimes.put(c.getID(),c);
    }

    public void removeCrime(Crime c){
        mCrimes.remove(c.getID());
    }

    public List<Crime> getCrimes(){
        return new ArrayList<>(mCrimes.values());
    }

    public Crime getCrime(UUID id){
        return mCrimes.get(id);
    }
}
