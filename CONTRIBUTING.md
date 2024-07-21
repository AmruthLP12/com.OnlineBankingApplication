# Contributing to Online Banking Application

First off, thank you for considering contributing to the Inventory Management System (IMS)! It's people like you who make the project better.

The following is a set of guidelines for contributing to the project. These are mostly guidelines, not rules. Use your best judgment, and feel free to propose changes to this document in a pull request.

## Table of Contents

- [How Can I Contribute?](#how-can-i-contribute)
    - [Reporting Bugs](#reporting-bugs)
    - [Suggesting Enhancements](#suggesting-enhancements)
    - [Your First Code Contribution](#your-first-code-contribution)
    - [Pull Requests](#pull-requests)
- [Development Setup](#development-setup)
    - [Java Style Guide](#java-style-guide)
    - [Commit Messages](#commit-messages)
- [Attribution](#attribution)



## How Can I Contribute?

### Reporting Bugs

If you find a bug in the project, please report it by following these steps:

1. **Check for existing issues:** Before reporting a bug, check if it's already reported in the [issues section](https://github.com/AmruthLP12/com.OnlineBankingApplication.git/issues).

2. **Create a new issue:** If no issue exists, create a new issue. Use a clear and descriptive title, and include details such as:
    - Steps to reproduce the issue
    - Expected behavior
    - Actual behavior
    - Screenshots or logs, if applicable

3. **Label the issue:** Add relevant labels to help categorize the issue (e.g., bug, enhancement, question).

### Suggesting Enhancements

To suggest a new feature or enhancement:

1. **Check for existing suggestions:** Review the [existing issues](https://github.com/AmruthLP12/com.OnlineBankingApplication.git/issues) to see if your idea has already been suggested.

2. **Create a new suggestion:** If no similar suggestion exists, create a new issue and use a clear and descriptive title. Include:
    - A detailed description of the feature
    - Why it would be useful
    - Any potential drawbacks

3. **Label the suggestion:** Add relevant labels to help categorize the suggestion (e.g., enhancement, feature request).

### Your First Code Contribution

For your first contribution:

1. **Fork the repository:**

    ```bash
    git fork https://github.com/AmruthLP12/com.OnlineBankingApplication.git
    ```

2. **Clone your fork:**

    ```bash
    git clone https://github.com/AmruthLP12/com.OnlineBankingApplication.git
    cd online-banking-application
    ```

3. **Create a branch for your work:**

    ```bash
    git checkout -b my-feature-branch
    ```

4. **Make your changes:** Implement the new feature or bug fix.

5. **Commit your changes:**

    ```bash
    git add .
    git commit -m "Add feature X"
    ```

6. **Push your changes:**

    ```bash
    git push origin my-feature-branch
    ```

7. **Open a pull request:** Go to your fork on GitHub, switch to your feature branch, and click on "Compare & pull request." Provide a clear description of your changes.

### Pull Requests

To create a pull request:

1. **Ensure your fork is up to date:** Sync your fork with the latest changes from the upstream repository.

    ```bash
    git checkout main
    git pull upstream main
    ```

2. **Create a new branch:** Create a new branch for your changes if you haven't already.

    ```bash
    git checkout -b new-feature-branch
    ```

3. **Commit your changes:** Ensure each commit message follows the [commit message guidelines](#commit-messages).

4. **Push your changes:**

    ```bash
    git push origin new-feature-branch
    ```

5. **Create a pull request:** Go to the upstream repository, switch to your branch, and click "Compare & pull request." Include a clear description of your changes.

6. **Review:** Address any feedback from project maintainers and update your pull request as needed.

## Development Setup

1. **Clone the repository:**

    ```bash
    git clone https://github.com/AmruthLP12/com.OnlineBankingApplication.git
    cd online-banking-application
    ```

2. **Install dependencies:**

    ```bash
    mvn install
    ```

3. **Set up the database:** Follow the [Database Setup](README.md#database-setup) section in the README.

4. **Run the application:**

    ```bash
    mvn exec:java -Dexec.mainClass="com.banking.ui.Main"
    ```

5. **Run the tests:**

    ```bash
    mvn test
    ```



### Java Style Guide

- Use 4 spaces for indentation.
- Follow [Oracle's Java Code Conventions](https://www.oracle.com/java/technologies/javase/codeconventions-contents.html).
- Document your code with Javadoc comments.

### Commit Messages

- **Format:** Use the imperative mood in the subject line. Example: "Fix bug in order processing"
- **Structure:**
    - Subject line (max 50 characters)
    - Blank line
    - Detailed explanation (optional)

- **Examples:**

    ```plaintext
    Fix bug in order processing

    The order processing logic had a bug where negative quantities were allowed. This change ensures that only positive quantities are accepted.
    ```

## Attribution

This project was created by [Amruth L P](https://github.com/AmruthLP12). If you have any questions or need further assistance, please feel free to reach out.
