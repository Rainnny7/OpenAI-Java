package me.braydon.openai.web.response.impl.model;

import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;
import me.braydon.openai.web.response.ResponseObject;

import java.util.Iterator;

/**
 * Represents a list of {@link Model}'s.
 *
 * @author Braydon
 */
@Getter @ToString(callSuper = true)
public final class ModelList extends ResponseObject implements Iterable<Model> {
    /**
     * The {@link Model}'s in this list.
     */
    private Model[] data;
    
    /**
     * Get the iterator for this list.
     *
     * @return the list iterator
     * @see ModelIterator for iterator
     */
    @Override @NonNull
    public Iterator<Model> iterator() {
        return new ModelIterator();
    }
    
    /**
     * The {@link Iterator} to use for {@link Model}'s.
     */
    public class ModelIterator implements Iterator<Model> {
        private int index; // The current model index
        
        @Override
        public boolean hasNext() {
            return index < data.length;
        }
        
        @Override @NonNull
        public Model next() {
            return data[index++];
        }
    }
}