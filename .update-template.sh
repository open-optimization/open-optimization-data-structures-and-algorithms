#! /bin/bash
if [ $# -ne 2 ]; then
    echo "usage: $0 FROM-DIRECTORY TO-DIRECTORY"
    echo "Copies some template files."
    exit 1
fi
from="$1"
to="$2"
(cd "$from" && tar cf - --exclude "Icon?" --exclude "._*" .gitattributes .gitignore .github ) | (cd "$to" && tar xvf - )
