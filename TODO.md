# DSA Arrays Restructure TODO

Current status: Starting implementation of approved plan.

## Steps (check off as completed):

### 1. Preparation (Git & Backup)
- [x] Check `git status` - ensure clean tree
- [x] `git pull origin main` to sync latest

### 2. Create Category Directories
- [x] mkdir Arrays/01-Binary-Search ...

### 3. Move Problem Directories (batch mv)
- [x] Binary Search: mv 33-search-in-rotated-sorted-array & 153.. to 01-Binary-Search/ ✅
- [x] Two Pointer (7): mv 15-3sum etc to 02-Two-Pointer/ ✅
- [x] Kadanes: mv 53-maximum-subarray,152.. to 03-Kadanes-Algorithm/ ✅
 - [x] Rotation/Manip: mv 31-next-permutation,189..,1878.. to 04-Array-Rotation-and-Manipulation/ ✅
- [x] Matrix: mv 48-rotate-image,54..,73.. to 05-Matrix-2D-Array/ ✅
 - [x] Monotonic Stack: mv 84-largest..,150..,943.. to 06-Monotonic-Stack/ ✅
- [x] Prefix/Suffix: mv 238..,560.. to 07-Prefix-Suffix/ ✅
 - [x] HashMap: mv 128..,136.. to 08-HashMap-HashSet/ ✅
 - [x] Greedy: mv 121..,169.. to 09-Greedy/ ✅

### 4. Cleanup
 - [x] rm Arrays/Solution.java ✅


### 5. Update Documentation
 - [x] Rewrite Arrays/README.md with hierarchy table ✅
 - [x] Edit root README.md: update structure diagram ✅ (no local links needed)

### 6. Git & Sync
- [ ] git add .
- [ ] git commit -m "feat: restructure Arrays into 9 pattern categories\n\n- Nested problem dirs under 01-Binary-Search to 09-Greedy\n- Updated READMEs with new structure\n- All 26 problems categorized per patterns"
- [ ] git pull origin main --rebase
- [ ] git push https://github.com/mayankgotnolife/DSA-challenge.git main

### 7. Verify
- [ ] Check `tree Arrays/` or GitHub repo matches target
- [ ] Update TODO with completions

*Last Updated: $(date)*
