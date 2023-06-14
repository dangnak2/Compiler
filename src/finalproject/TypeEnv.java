package finalproject;
// TypeEnv.java
// Type environment for S
import java.util.*;

// <id, type> 
class Entry {
   Identifier id;
   Type type;
   
   Entry (Identifier id, Type t) {
     this.id = id;
     this.type = t;
   }
   
}

class TypeEnv extends Stack<Entry> {
    public TypeEnv() { }
    
    public TypeEnv(Identifier id, Type t) {
        push(id, t);
    }
    
    public TypeEnv push(Identifier id, Type t) {
        this.push(new Entry(id, t));
        return this;
    }
    
//     (1) Contatins Function Implementation
	public boolean contains (Identifier v) {
        // Contains Implementation
		
		if(v == null) {
			for(int i=0; i<=elementCount; i++) {
				if(elementData[i]==null) return true;
			}
		} 
		else {
			// Entry 인스턴스를 하나씩 가져와서 entry에 저장한다.
			for(int i=0; i<this.size(); i++) {
				
				// 저장된 entry의 id와 매개변수로 받은 v의 값이 일치한다면
				// 해당 인스턴스가 존재하므로 true를 반환한다.
				Entry entry = this.get(i);
				if(v.equals(entry.id)) return true;
			}
		}
		return false;
    }

    // (2) Get Function Implementation
    public Type get (Identifier v) {
        // Get Implementation\
    	
    	// Entry 인서턴스를 하나씩 가져와서 entry에 저장한다.
    	for(int i=this.size()-1; i>=0; i--) {
    		
    		// 저장된 entry의 id와 매개변수로 받은 v의 값이 일치한다면
    		// 일치하는 인스턴스의 타입을 반환한다.
    		Entry entry = this.get(i);
    		if(entry.id.equals(v)) {
    			return entry.type;
    		}
    	}
		return this.get(v);
    }
}