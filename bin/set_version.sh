#!/bin/bash
# 设置 pom.xml 中的项目版本号
#-----------------------------------------------------------------
# 命令执行示例：
# bin/set_version.sh [old_version] [new_version]
#-----------------------------------------------------------------

OLD_VERSION="<version>$1</version>"
NEW_VERSION="<version>$2</version>"
POM_PATH="./pom.xml"

echo "Set versions for all modules : $NEW_VERSION"
bin/_sed.sh $OLD_VERSION $NEW_VERSION $POM_PATH

items=`ls | grep 'exp-libs-'`
for item in $items
do
    echo "Set versions for $item : $NEW_VERSION"
    pomPath="./$item/pom.xml"

    if [ -f "$pomPath" ]; then
        bin/_sed.sh $OLD_VERSION $NEW_VERSION $pomPath
    fi
done
echo "Done ."