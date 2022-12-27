package observer;

import java.util.EmptyStackException;
import java.util.Stack;

/*
Use the class you've implemented in previous assignment
 */
public class UndoableStringBuilder {
    private StringBuilder mystring ;
    private Stack<String> stUndo;

    /**
     Empty constructor for String Builder
     * */
    public UndoableStringBuilder()
    {
        mystring = new StringBuilder();
        stUndo = new Stack<>();
    }

    /**
     * Appends the specified string to this character sequence.
     * @param str - the string you asked to append
     * @return object of Undoablestringbuilder after the changes
     */
    public UndoableStringBuilder append(String str)
    {
        stUndo.push(mystring.toString());
        mystring = mystring.append(str) ;
        return this;
    }

    /**
     * Removes the characters in a substring of this sequence. The substring begins
     *  at the specified start and extends to the character at index
     *  end - 1 or to the end of the sequence if no such character exists.
     *  If start is equal to end, no changes are made.
     * @param start in what index to begin the deletion
     * @param end in what index to end the deletion
     * @return  object of Undoablestringbuilder after the changes
     */
    public UndoableStringBuilder delete(int start, int end)
    {
        try{
            stUndo.push(mystring.toString());
            mystring.delete(start, end);
            return this;

        }
        catch (IndexOutOfBoundsException e)
        {
            System.out.println("Can't delete out of boundaries");
            return this;
        }

    }

    /**
     * Inserts the string into this character sequence.
     * @param offset in what index to put the new string
     * @param str tha asked string to insert
     * @return object of Undoablestringbuilder after the changes
     */
    public UndoableStringBuilder insert(int offset, String str)
    {
        try {
            stUndo.push(mystring.toString());
            mystring = mystring.insert(offset, str);
            return this;
        }
        catch(StringIndexOutOfBoundsException e)
        {
            System.err.println("offset Out of boundaries");
            return this;
        }
    }

    /**
     *  Replaces the characters in a substring of this sequence with characters in
     *      the specified String. The substring begins at the specified start and
     *      extends to the character at index end - 1 or to the end of the sequence if
     *      no such character exists. First the characters in the substring are removed
     *      and then the specified String is inserted at start. (This sequence will be
     *      lengthened to accommodate the specified String if necessary).
     * @param start in what index to put the new string
     * @param end in what index to end the replacement
     * @param str tha asked string to insert
     * @return object of Undoablestringbuilder after the changes
     */
    public UndoableStringBuilder replace(int start,int end, String str)
    {
        try {
            stUndo.push(mystring.toString());
            mystring = mystring.replace(start, end , str);
            return this;
        }
        catch(StringIndexOutOfBoundsException e)
        {
            System.err.println("Start or end Out of boundaries");
            return this;
        }
        catch (NullPointerException e)
        {
            System.err.println("Can't replace with null ");
            return this;
        }

    }

    /**
     * Causes this character sequence to be replaced by the reverse of the
     *      sequence.
     * @return object of Undoablestringbuilder after the changes
     */
    public UndoableStringBuilder reverse()
    {
        stUndo.push(mystring.toString());
        mystring = mystring.reverse();
        return this;
    }

    /** undo the last operation on the string.
     **/
    public void Undo() {
        try {
            mystring = new StringBuilder(stUndo.pop());
        }

        catch(EmptyStackException e)
        {
        }
    }

    /**
     *
     * @return mystring-stringbuilder as a string
     */
    public String toString()
    {
        return this.mystring.toString();
    }
}
