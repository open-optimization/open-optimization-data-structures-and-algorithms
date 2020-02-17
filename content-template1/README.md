# Content Template 1
Here is one structure for setting up a book.  

# Features

## Subfiles

This structure is setup to use the latex "subfiles" structure for the book.  This allows you to create sections that can be compiled (pdflatex) as standalone sections that inherit the preamble of the main file, but also to be compiled together as one main file.  This makes editing sections easier when you don't want to have to compile the entire book each time you want to view your edit.

Subfiles are included using the "\import{ ..}" command instead  of "\input{ .. }" .  Also, subfiles must have a header that references the main file.  

### File structure
Due to the use of "subfiles", the files are structured within folders such that the main file and the section files will all see the appropriate files with the same commands.  For instance, the preamble is referenced as "../preamble.tex" and stored in a folder above the folder where the main textbook or where the subfiles are.  This allows the subfiles and the main file to all see the preamble appropriately, but to keep them organized into separate folders. Note: The preamble files are not very clean at the moment and you will want to edit these to fit your commands and style.  That said, using fewer complicated macros will help enable others to reuse and remix your material easier.


## Figures
Properly citing figures is important.  As such, a structure has been setup to store a folder of figures and reference them from stored metadata.  Related commands are stored in "preamble0-biblatex.tex".  Examples are given in the example main file.

### Images with metadata
Images are separated into "figures-static" and "figures-source" to describe if the figure is only saved as a static figure (.png, .jpg, .pdf, etc) or if the source of creation (.py, .tikz, etc) is saved as well.  Having the source is great because it allows others to borrow and modify the figure as they may want to.

There is a file "00_METADATA.bib" in each folder "figures-source" and "figures-static".  This contains data about the figure in the format:

@Online{wiki/File/integer-programming.png,
  author =	 {{\copyright~Fanosta  \href{https://creativecommons.org/licenses/by-sa/4.0/}{CC BY-SA 4.0}.}}, 
  title =	 {IP polytope with LP relaxation},
  shorttitle =	 {Big-O Notation},
  year =	 {2019},
  url =
                  {https://en.wikipedia.org/wiki/Integer_programming#/media/File:IP_polytope_with_LP_relaxation.svg},
  urldate =	 {2020-1-11},
  options =	 {skipbib=true},
}


Using the commands defined in the "preamble0-biblatex.tex", this metadata is accessed when including the associated figure with proper citation of the figure with an added footnote to explain where it came from.




### Images without using metadata
If you prefer not to use metadata, you can also reference figures in a more straightforward way.  See the examples in the main.tex file.





