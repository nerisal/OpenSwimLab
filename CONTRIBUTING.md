# Contributing to OpenSwimLab

Thank you for your interest in contributing to OpenSwimLab. Contributions of all kinds are welcome, including bug reports, feature suggestions, documentation improvements, testing, and code contributions.
Please take a moment to review these guidelines before submitting a contribution. They help keep the project consistent, maintainable, and easy to collaborate on.

## Project Status

OpenSwimLab is currently in an early alpha stage. The application is under active development and is not yet ready for general use.
Features, internal structures, and development practices may change as the project evolves. Before starting work on a significant contribution, consider opening an issue to discuss your proposal and ensure it aligns with the project's direction.

## How to Contribute

### Reporting Bugs

When reporting a bug, please provide as much relevant information as possible:

- A clear and descriptive title.
- A description of the problem and the expected behavior.
- Steps to reproduce the issue, if applicable.
- Relevant error messages, logs, or screenshots.
- Any additional context that may help identify the cause.

Please check existing issues before opening a new one to avoid duplicates.

### Suggesting Features

Feature suggestions are welcome. When proposing a new feature, please explain:

- The problem it aims to solve.
- The expected behavior and intended benefits.
- Any relevant use cases or implementation considerations.

For substantial changes, open an issue for discussion before investing significant time in implementation.

### Submitting Code Changes

When contributing code, please follow these principles:

- Keep changes focused on a single logical purpose.
- Follow the existing code style and project structure.
- Prefer clear, maintainable solutions over unnecessary complexity.
- Avoid unrelated modifications within the same contribution.
- Update relevant documentation when behavior, configuration, or project requirements change.
- Add or update tests when appropriate and feasible.
- Verify that your changes build successfully and that relevant tests pass, where supported by the current state of the project.

If a change is incomplete or depends on further work, clearly communicate its current limitations.

## Commit Convention

OpenSwimLab follows a lightweight version of [Conventional Commits](https://www.conventionalcommits.org/), with a small set of additional project-specific commit types.

All commit messages must be written in English.

### Commit Message Format

Use the following format:

`type(scope): description`

Where:

- **type** identifies the category of change.
- **scope** is an optional identifier for the affected area of the project.
- **description** briefly summarizes the change.

For example:

`feat(workouts): add workout renaming`

Use a scope when it helps clarify the purpose of a commit. Keep scope names short, descriptive, and consistent with the terminology used throughout the project.

### Commit Types

| Type | Description |
|---|---|
| `feat` | Introduces a new feature or capability. |
| `fix` | Fixes a bug or incorrect behavior. |
| `refactor` | Restructures existing code without changing its intended behavior. |
| `ui` | Changes the user interface, layout, or visual presentation. |
| `style` | Applies code formatting or stylistic changes without affecting behavior. |
| `test` | Adds, updates, or fixes tests. |
| `docs` | Adds or updates documentation. |
| `build` | Changes build configuration, build scripts, or dependencies. |
| `ci` | Changes continuous integration or delivery workflows. |
| `perf` | Improves performance or resource efficiency. |
| `data` | Changes data models, database schemas, or migrations. |
| `chore` | Performs maintenance tasks that do not fit another category. |

Use the most appropriate type for the primary purpose of the change. Do not introduce new types unnecessarily; if an existing type accurately describes the change, use it.

### Commit Message Guidelines

Please follow these conventions when writing commit messages:

1. **Use English throughout.** Commit subjects, scopes, bodies, and footers must be written in English.
2. **Use lowercase.** Keep the type, scope, and description in lowercase, except where proper nouns or technical conventions require otherwise.
3. **Use the imperative mood.** Describe what the commit does using verbs such as `add`, `fix`, `update`, `remove`, or `support`.
4. **Keep descriptions concise.** Aim for approximately 50–72 characters for the subject line when practical, without sacrificing clarity.
5. **Do not end the subject with a period.**
6. **Be specific.** Avoid vague messages such as `update`, `changes`, `misc`, or `fix stuff`.
7. **Keep commits focused.** Each commit should represent one logical change, rather than combining unrelated modifications.
8. **Use additional context when necessary.** For complex changes, provide a commit body explaining the motivation, relevant implementation details, or consequences.

### Examples

| Scenario | Example |
|---|---|
| Add a feature | `feat(workouts): add workout renaming` |
| Fix a navigation issue | `fix(navigation): preserve screen state` |
| Improve a layout | `ui(home): improve workout card layout` |
| Change a database schema | `data(database): add workout name column` |
| Update documentation | `docs(readme): clarify alpha status` |
| Refactor navigation logic | `refactor(navigation): simplify route handling` |
| Update dependencies | `build: update project dependencies` |
| Add tests | `test(workouts): cover workout name validation` |

### Breaking Changes

If a change introduces a breaking change, append `!` to the type or type and scope, and explain the impact in a `BREAKING CHANGE` footer.

For example:

`feat(data)!: replace workout identifier format`

The commit body or footer should describe what changed and any necessary migration steps.

## Pull Requests

Before submitting a pull request, please ensure that:

- The changes address a clear purpose.
- The code follows the project's existing conventions.
- Relevant tests have been added or updated where appropriate.
- The project builds successfully, where supported.
- Documentation has been updated when necessary.
- Commit messages follow the conventions described above.
- No unrelated changes or sensitive information are included.

Pull requests should have a clear title and a description explaining the motivation, the changes introduced, and any relevant limitations or testing performed. Reference related issues when applicable.
For significant changes, consider discussing the proposal in an issue before opening a pull request.

## Communication and Collaboration

Please be respectful and constructive when discussing issues, reviewing code, and interacting with other contributors.
Different approaches and opinions are welcome. Focus discussions on the technical merits of a proposal and on what best serves the project and its users.
If you are unsure whether a change fits the project's direction, feel free to open an issue and ask before proceeding.

## Final Notes

These guidelines are intended to support collaboration, not create unnecessary barriers. As OpenSwimLab develops, the contribution process and conventions may evolve.

Thank you for helping improve OpenSwimLab! 🏊