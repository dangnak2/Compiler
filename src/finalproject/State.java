package finalproject;

import java.util.*;
// State as stack 

// <id, val> 
class Pair {
   Identifier id;
   Value val;
   
   Pair (Identifier id, Value v) {
     this.id = id;
     this.val = v;
   }
}

class State extends Stack<Pair> {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public State() { }
    
    public State(Identifier id, Value val) {
        push(id, val);
    }

    // (1) Push function Implementation
    public State push(Identifier id, Value val) {
    	// Push Implementation
    	this.push(new Pair(id, val));
    	return this;
    	
    }

    // (2) Pop function Implementation (Optional)
    public Pair pop() {
    	// Pop Implementation (Optional)
    	
    	return super.pop();
    	
    }
    
    // (3) Lookup function Implementation
    public int lookup (Identifier v) {
       // Lookup Implementation
    	
    	// Pair인스턴스를 하나씩 가져와서 pair에 저장한다.
    	for(int i=this.size()-1; i>=0; i--) {
    		
    		// 매개변수로 받은 id의 값과 일치하는 pair.id가 있다면
    		// 해당 인덱스를 반환한다.
    		Pair pair = this.get(i);
    		if(pair.id.equals(v)) {
    			return i;
    		} 
    	}
    	
    	return this.lookup(v);
    }
    
    // (4) Set Function Implementation
    public State set(Identifier id, Value val) {
    	// Set Implementation
    	

    	// Pair인스턴스를 하나씩 가져와서 pair에 저장한다.
    	for(int i=this.size()-1; i>=0; i--) {
    		
    		// 매개변수로 받은 id의 값과 일치하는 pair.id가 있다면
    		// 해당 인스턴스의 val에 매개변수로 받은 val를 대입한다.
    		// super.set()를 통해 해당 elementData를 변경된 pair로 setting 해준다.
    		Pair pair = this.get(i);
    		if(pair.id.equals(id)) {
    			pair.val = val;
    			super.set(i, pair);
    			
    	    	// 중첩 Let문에서 동일한 id가 있는 경우
    	    	// id가 일치하는 가장 가까운 stack의 값만 변경
    			break;
    		}
    	}
    	return this;
    }
    
    // (5) Get Function Implementation
    public Value get (Identifier id) {
    	
    	// Pair인스턴스를 하나씩 가져와서 pair에 저장한다.
    	for(int i=this.size()-1; i>=0; i--) {
    		
    		// 매개변수로 받은 id의 값과 일치하는 pair.id가 있다면
    		// 해당인스턴스의 val값을 반환한다.
    		Pair pair = this.get(i);
    		if(pair.id.equals(id)) {
    			return pair.val;
    		}
    	}
    	
    	return this.get(id);
    }

}