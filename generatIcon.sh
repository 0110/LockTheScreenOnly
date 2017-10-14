#!/bin/bash
FOLDER_PREFIX=src/main/res/mipmap-
FILENAME=ic_launcher.png

COMMAND="inkscape -z -e"
SOURCE=system-lock-screen.svg

if [ ! -f $SOURCE ]; then
 echo "Cannout find the file $SOURCE"
 exit 1
fi

$COMMAND ${FOLDER_PREFIX}hdpi/$FILENAME -w 72 -h 72 $SOURCE
$COMMAND ${FOLDER_PREFIX}mpdi/$FILENAME -w 48 -h 48 $SOURCE
$COMMAND ${FOLDER_PREFIX}xhdpi/$FILENAME -w 96 -h 96 $SOURCE
$COMMAND ${FOLDER_PREFIX}xxhdpi/$FILENAME -w 144 -h 144 $SOURCE
$COMMAND ${FOLDER_PREFIX}xxxhdpi/$FILENAME -w 192 -h 192 $SOURCE

exit 0
