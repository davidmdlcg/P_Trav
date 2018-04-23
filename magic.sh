BRANCH="master"

# Only for master
if [ "$TRAVIS_BRANCH" = "$BRANCH" ]; then
  
  # Is this not a Pull Request?
  if [ "$TRAVIS_PULL_REQUEST" = false ]; then
    
    # Is this not a build which was triggered by setting a new tag?
    if [ -z "$TRAVIS_TAG" ]; then
      #echo -e "Tagging commit.\n"

      git config --global user.email "travis@travis-ci.org"
      git config --global user.name "Travis"

      git checkout master
      # Add tag and push to master.
      #git tag -a v${TRAVIS_BUILD_NUMBER} -m "Travis build $TRAVIS_BUILD_NUMBER pushed a tag."
      #git fetch origin
      
      # Upload doc file
      echo "Magic: Commiting changes to project"
      git add .
      git commit -m "[skip ci] TRAVIS Updated cucumber report"
      echo "Magic: pushing changes"
      git push https://ExtremoBlando:$MAGIC_TOKEN@github.com/jjluczyn/PongCS-G7-2018 master #--tags    
      echo -e "Magic done.\n"
  fi
  fi
fi
