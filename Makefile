# Assignment 1 Makefile
# Gift Mugweni
# 22 February 2020

JAVAC=/usr/bin/javac
JAVADOC=/usr/bin/javadoc
.SUFFIXES: .java .class
SRCDIR=src
BINDIR=bin
OUTDIR=output
DOC=doc

$(BINDIR)/%.class:$(SRCDIR)/%.java
	$(JAVAC) -d $(BINDIR)/ -cp $(BINDIR) $<
	
CLASSES=LSHelper.class LSData.class LSArray.class LSArrayApp.class LSBSTreeNode.class LSBSTree.class LSBSTApp.class
CLASS_FILES=$(CLASSES:%.class=$(BINDIR)/%.class)

default: $(CLASS_FILES)

clean:
	rm $(BINDIR)/*.class

doc:
	$(JAVADOC) -d $(DOC)/ $(SRCDIR)/*.java
