# Publish on GitHub

1. Create a **public** empty repository called `java-data-structures-lab` (optionally initialize with a README).
2. In ChatGPT, reply **"Repositório criado"**; the connected GitHub integration can publish this prepared source tree to the new repo.
3. Or publish yourself with Git:

```bash
git init
git add .
git commit -m "feat: Java sorting and custom collections study lab"
git branch -M main
git remote add origin https://github.com/YOUR_USERNAME/java-data-structures-lab.git
git push -u origin main
```

If GitHub initialized the repository with an initial commit, clone it first and copy these files into the clone to avoid divergent histories.

Do not commit `target/`, IDE settings, or any secrets. The project does not require API keys.
